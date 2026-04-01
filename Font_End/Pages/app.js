// 🔹 Get JWT token from localStorage (login eken save karala thiyenne)
const token = localStorage.getItem('token');

// 🔹 Villa list container
const villaList = document.getElementById('villa-list');

// 🔹 Load villas by district (example: Galle)
async function loadVillas(district = 'Galle') {
    try {
        const response = await fetch(`http://localhost:8080/api/v1/villas/by-district?district=${district}`, {
            headers: {
                'Authorization': 'Bearer ' + token,
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            const err = await response.json();
            throw new Error(err.message || 'Failed to load villas');
        }

        const villas = await response.json();
        displayVillas(villas);

    } catch (error) {
        console.error('Error loading villas:', error);
        villaList.innerHTML = `<p class="text-danger">Error loading villas: ${error.message}</p>`;
    }
}

// 🔹 Display villas in HTML
function displayVillas(villas) {
    villaList.innerHTML = '';
    if (!villas || villas.length === 0) {
        villaList.innerHTML = '<p>No villas found in this district.</p>';
        return;
    }

    villas.forEach(v => {
        const card = document.createElement('div');
        card.className = 'col-md-4 mb-3';
        card.innerHTML = `
            <div class="card p-3">
                <h5 class="card-title">${v.name}</h5>
                <p>Location: ${v.location}</p>
                <p>District: ${v.district}</p>
                <p>Price: $${v.price}</p>
            </div>
        `;
        villaList.appendChild(card);
    });
}

// 🔹 On page load, fetch villas
window.addEventListener('DOMContentLoaded', () => {
    loadVillas(); // default district = Galle
});