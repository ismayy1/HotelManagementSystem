package com.tpe.service;

import com.tpe.exception.GuestNotFoundException;
import com.tpe.exception.RoomNotFoundException;
import com.tpe.model.Guest;
import com.tpe.model.Reservation;
import com.tpe.model.Room;
import com.tpe.repository.GuestRepository;
import com.tpe.repository.ReservationRepository;
import com.tpe.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationServiceImplementation implements ReservationService {


    private Scanner scanner;

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;

    public ReservationServiceImplementation(ReservationRepository reservationRepository,
                                  GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }


    //step 26 d : save the Reservation
    @Override
    public Reservation saveReservation() {

        scanner= new Scanner(System.in);

        System.out.println("Enter Guest By Id :");
        Long guestId= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the Room Id : ");

        Long roomId= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the check -in date (yyyy-MM-dd): ");//2024-5-18
        LocalDate checkInDate= LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the check -in date (yyyy-MM-dd): ");//2024-5-18
        LocalDate checkOutDate= LocalDate.parse(scanner.nextLine());


        try {
            Guest existGuest = guestRepository.findGuestById(guestId);
            if (existGuest == null){
                throw  new GuestNotFoundException("Guest Not Found  with Id : " + guestId);
            }

            Room existRoom= roomRepository.findRoomById(roomId);
            if (existRoom == null){
                throw  new RoomNotFoundException(" Room Not Found With Id : " + roomId);
            }

            Reservation reservation = new Reservation();

            reservation.setGuest(existGuest);;
            reservation.setRoom(existRoom);

            reservation.setCheckIn(checkInDate);
            reservation.setCheckOut(checkOutDate);

            reservationRepository.saveReservation(reservation);

            System.out.println("Reservation created Successfully ... Reservation Id : "+ reservation.getId());

            return  reservation;
        }catch (GuestNotFoundException | RoomNotFoundException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    // step 27 b:
    @Override
    public void findReservationById(Long id) {
        Reservation foundReservations = reservationRepository.findReservationBuId(id);

        if (foundReservations != null) {
            System.out.println(foundReservations);
        } else {
            System.out.println("Reservation not Found with id: " + id);
        }
    }

    // step 28 d: display all reservations
    @Override
    public List<Reservation> displayAllReservations() {
        List<Reservation> reservationList =  reservationRepository.findAllReservations();
        return reservationList;
    }

    @Override
    public void deleteReservationById(Long id) {

        reservationRepository.deleteReservationById(id);

    }
}
