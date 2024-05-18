package com.tpe.repository;

import com.tpe.model.Guest;

import java.util.List;

public interface GuestRepository {

    // step 22 a: save guest
    void saveGuest(Guest guest);

    //23a : findGuestById

    Guest findGuestById(Long guestId);

    //24a: deleteGuestById
    void deleteGuestById(Long id);

    //25a: findALlGuest
    List<Guest> findAllGuest();

}
