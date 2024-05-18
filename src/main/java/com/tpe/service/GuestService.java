package com.tpe.service;

import com.tpe.model.Guest;

import java.util.List;

public interface GuestService {

    // step 22 c: save the Guest
    Guest saveGuest();

    //23c : findGuestById
    void findGuestById(Long id);

    //25c: findALlGuest
    List<Guest> findAllGuest();


    //24c: deleteGuestById
    void deleteGuestId(Long id);

}
