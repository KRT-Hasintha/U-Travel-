//package org.example.back_end.Controller;
//
//
//import lombok.RequiredArgsConstructor;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.example.back_end.Dto.LocationDTO;
//import org.example.back_end.Dto.RideLocationUpdateDTO;
//import org.example.back_end.Entity.Ride;
//import org.example.back_end.Service.RideService;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/rides")
//@RequiredArgsConstructor
//@CrossOrigin
//public class RideController {
//
//    private final RideService rideService;
//
//    // USER → request a ride
////    @PostMapping("/request")
////    @PreAuthorize("hasRole('USER')")
////    public Ride requestRide(@RequestBody Ride ride){
////        ride.setStatus("REQUESTED");
////        return rideService.save(ride);
////    }
//
////    //new
////    @PostMapping("/request")
////    @PreAuthorize("hasRole('USER')")
////    public Ride requestRide(@RequestBody Ride ride){
////        ride.setStatus("REQUESTED");
////        return rideService.save(ride);
////    }
//@PostMapping("/request")
//@PreAuthorize("hasRole('USER')")
//public Ride requestRide(
////        @RequestParam Long vehicleId,
////        @RequestParam Double lat,
////        @RequestParam Double lng,
////        Authentication auth
////){
////    return rideService.requestRide(auth.getName(), vehicleId, lat, lng);
////}
////
////    // PROVIDER → accept a ride
////    @PutMapping("/accept")
////    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
////    public Ride acceptRide(@RequestParam Long rideId,
////                           @RequestParam Long vehicleId){
////        return rideService.acceptRide(rideId, vehicleId);
////    }
////
////    @PutMapping("/update-location") //new
////    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
////    public Ride updateRideLocation(@RequestBody RideLocationUpdateDTO locationDTO) {
////        return rideService.updateRideLocation(locationDTO);
////    }
////
////    @GetMapping("/{rideId}") //new
////    @PreAuthorize("hasRole('USER')")
////    public Ride getRide(@PathVariable Long rideId){
////        return rideService.getRide(rideId);
////    }
////
////    @GetMapping("/requests")
////    @PreAuthorize("hasAnyRole('PROVIDER','ADMIN')")
////    public List<Ride> getRideRequests() {
////        return rideService.getRequestedRides();
////    }
////
////    @PostMapping("/request")
////    @PreAuthorize("hasRole('USER')")
////    public Ride requestRide(@RequestBody LocationDTO locationDTO) {
////        Ride ride = new Ride();
////        ride.setPickupLat(locationDTO.getLatitude());
////        ride.setPickupLng(locationDTO.getLongitude());
////        ride.setStatus("REQUESTED");
////        return rideService.save(ride);
////    }
//}
package org.example.back_end.Controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.Entity.Ride;
import org.example.back_end.Service.RideService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rides")
@RequiredArgsConstructor
@CrossOrigin
public class RideController {

//    private final RideService rideService;
//

//    @PostMapping("/request")
//    @PreAuthorize("hasRole('USER')")
//    public Ride requestRide(
//            @RequestParam Long vehicleId,
//            @RequestParam Double lat,
//            @RequestParam Double lng,
//            Authentication auth
//    ){
//        return rideService.requestRide(auth.getName(), vehicleId, lat, lng);
//    }
//
//
//    @GetMapping("/my")
//    @PreAuthorize("hasRole('USER')")
//    public Ride myRide(Authentication auth){
//        return rideService.getMyRide(auth.getName());
//    }
//
//
//    @GetMapping("/requests")
//    @PreAuthorize("hasRole('PROVIDER')")
//    public List<Ride> myRequests(Authentication auth){
//        return rideService.getMyRequests(auth.getName());
//    }
//
//
//    @PutMapping("/accept")
//    @PreAuthorize("hasRole('PROVIDER')")
//    public Ride accept(@RequestParam Long rideId){
//        return rideService.acceptRide(rideId);
//    }

    private final RideService rideService;


    // USER
    @PostMapping("/request")
    @PreAuthorize("hasRole('USER')")
    public Ride requestRide(
            @RequestParam Long vehicleId,
            @RequestParam Double lat,
            @RequestParam Double lng,
            Authentication auth
    ){
// return rideService.requestRide(auth.getName(), lat, lng);
        return rideService.requestRide(auth.getName(), vehicleId, lat, lng);
    }




    // DRIVER - ALL REQUESTS
    @GetMapping("/requests")
    @PreAuthorize("hasRole('PROVIDER')")
    public List<Ride> allRequests(){
        return rideService.getAllPending();
    }

    // ACCEPT
    @PutMapping("/accept")
    @PreAuthorize("hasRole('PROVIDER')")
    public Ride accept(@RequestParam Long rideId, Authentication auth){
        return rideService.acceptRide(rideId, auth.getName());
    }


}