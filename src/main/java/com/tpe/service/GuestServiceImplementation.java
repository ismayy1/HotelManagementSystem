package com.tpe.service;

import com.tpe.model.Guest;
import com.tpe.repository.GuestRepository;

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

        return null;
    }
}
