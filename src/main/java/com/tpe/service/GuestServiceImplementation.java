package com.tpe.service;

import com.tpe.exception.GuestNotFoundException;
import com.tpe.model.Address;
import com.tpe.model.Guest;
import com.tpe.repository.GuestRepository;

import java.util.List;
import java.util.Scanner;

public class GuestServiceImplementation implements GuestService {

    private Scanner scanner;

    private final GuestRepository guestRepository;

    public GuestServiceImplementation(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // step 22 d: save the guest
    @Override
    public Guest saveGuest() {

        scanner = new Scanner(System.in);

        Guest guest = new Guest();

        System.out.println("Please enter the guest name: ");
        guest.setName(scanner.nextLine());

        // create Address object
        Address address = new Address();

        System.out.println("Enter the street: ");
        address.setAddress(scanner.nextLine());

        System.out.println("Enter the country: ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter the zipCode: ");
        address.setZipCode(scanner.nextLine());

        // set the address for the guest
        guest.setAddress(address);

        // save the guest using the guest repository
        guestRepository.saveGuest(guest);

        System.out.println("Guest Saved successfully with and id: " + guest.getId());

        return guest;
    }

    //23d : findGuestById
    @Override
    public void findGuestById(Long id) throws GuestNotFoundException {
        try {
            Guest foundGuest = guestRepository.findGuestById(id);
            if (foundGuest != null) {
                System.out.println("---------------------------------");
                System.out.println(foundGuest);
            } else {
                throw new GuestNotFoundException("Guest not found with ID: " + id);
            }
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }








    //25c: findALlGuest
    @Override
    public List<Guest> findAllGuest() {
        try {
            List<Guest> guests = guestRepository.findAllGuest();
            if (!guests.isEmpty()) {
                for (Guest guest : guests) {
                    System.out.println(guest);
                }
            } else {
                throw new GuestNotFoundException("Guest  not found");
            }
            return guests;
        }catch (GuestNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //24d: deleteGuestById
    @Override
    public void deleteGuestId(Long id) {
        try {
            Guest existingGuest = guestRepository.findGuestById(id);
            if (existingGuest == null) {
                throw new GuestNotFoundException("Guest  not found with ID: " + id);
            }
            guestRepository.deleteGuestById(id);
            throw new GuestNotFoundException("Guest  delete successfully  with ID: " + id);
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
