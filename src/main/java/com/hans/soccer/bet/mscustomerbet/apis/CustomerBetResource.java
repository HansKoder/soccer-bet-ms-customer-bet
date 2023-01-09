package com.hans.soccer.bet.mscustomerbet.apis;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.dtos.PrognosticUpdateDTO;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.services.CustomerBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/customers-bet")
public class CustomerBetResource {

    @Autowired
    private CustomerBetService customerBetService;

    @PostMapping("/")
    ResponseEntity<?> addNewCustomerBet (@RequestBody CustomerBet customerBet) {
        try {
            return ResponseEntity.ok().body(customerBetService.save(customerBet));
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }

    // Filter CustomerBets [All]
    @GetMapping("/")
    ResponseEntity<?> getCustomerBets () {
        try {
            return ResponseEntity.ok().body(customerBetService.findAll());
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }

    // Filter CustomerBet By ID
    @GetMapping("/id/{customerBetId}")
    ResponseEntity<?> getCustomerBetById (@PathVariable String customerBetId) {
        try {
            Optional<CustomerBet> optionalCustomerBet = customerBetService.findCustomerBetId(customerBetId);

            if (optionalCustomerBet.isEmpty()) {
                String notFound = "CustomerBet with the ID " + customerBetId + " Not found in own database";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", notFound));
            }

            return ResponseEntity.ok().body(optionalCustomerBet.get());
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }

    // Filter CustomerBets with Document of customer
    @GetMapping("/customer/{customer}")
    ResponseEntity<?> getCustomersByCustomerDocument (@PathVariable String customer) {
        try {
            List<CustomerBet> list = customerBetService.findCustomerBetsByCustomer(customer);

            if (list.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(list);
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }

    // Filter CustomerBets with BetId of Prognostic
    @GetMapping("/bet/{bet}")
    ResponseEntity<?> getCustomersByBetId(@PathVariable String bet) {
        try {
            List<CustomerBet> list = customerBetService.findCustomerBetsByBet(bet);

            if (list.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok().body(list);
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }

    // Update Prognostic Update
    @PutMapping("/update-prognostic")
    ResponseEntity<?> updatePrognostic (@RequestBody PrognosticUpdateDTO prognosticUpdateDTO) {
        try {
            if (Optional.ofNullable(prognosticUpdateDTO.getCustomerBetId()).isEmpty()) {
                String badRequest = "Customer Bet ID is mandatory";

                return ResponseEntity.badRequest().body(Collections.singletonMap("error", badRequest));
            }

            Optional<CustomerBet> optionalCustomerBet = customerBetService.findCustomerBetId(prognosticUpdateDTO.getCustomerBetId());

            if (optionalCustomerBet.isEmpty()) {
                String notFound = "Customer Bet ID " + prognosticUpdateDTO.getCustomerBetId() + " Not found is own database";

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", notFound));
            }

            CustomerBet updated = optionalCustomerBet.get();

            if (!updated.getStatus().equals(Status.PLAY)) {
                String notUpdate = "Cannot update prognostic because Match have started!";

                return ResponseEntity.badRequest().body(Collections.singletonMap("error", notUpdate));
            }

            updated.getPrognostic().setWinner(prognosticUpdateDTO.getWinner());

            customerBetService.save(updated);

            return ResponseEntity.ok(Collections.singletonMap("msg", "Update prognostic with successful"));
        } catch (Exception exception) {
            String err = exception.getMessage();

            return ResponseEntity.internalServerError().body(Collections.singletonMap("error", err));
        }
    }
}
