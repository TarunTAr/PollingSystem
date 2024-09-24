package com.GroupAssessment2.PollingSystem.controllers;

import com.GroupAssessment2.PollingSystem.models.PollResult;
import com.GroupAssessment2.PollingSystem.services.PollResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll-results")
public class PollResultController {

    @Autowired
    private PollResultService pollResultService;

    @PostMapping("/submit")
    public ResponseEntity<PollResult> submitPollResult(@RequestParam String email, 
                                                       @RequestParam String selectedOption, 
                                                       @RequestParam Long pollId) {
        PollResult savedResult = pollResultService.submitPollResult(email, selectedOption, pollId);
        return ResponseEntity.ok(savedResult);
    }


    @GetMapping("/all")
    public List<PollResult> getAllPollResults() {
        return pollResultService.getAllPollResults();
    }
}
