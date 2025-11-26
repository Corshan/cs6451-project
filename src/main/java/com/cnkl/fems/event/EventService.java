package com.cnkl.fems.event;

import com.cnkl.fems.budget.BudgetService; // Dependency for financial rule
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final BudgetService budgetService;

    public EventService(EventRepository eventRepository, BudgetService budgetService) {
        this.eventRepository = eventRepository;
        this.budgetService = budgetService;
    }


    @Transactional
    public Event createEvent(Event event) {

        if (budgetService.canCommitExpense(event.getCost())) {


            budgetService.commitExpense(event.getCost());


            event.setStatus("Accepted");
            return eventRepository.save(event);

        } else {

            event.setStatus("Rejected");
            eventRepository.save(event);
            throw new RuntimeException("Event cost exceeds remaining budget (Event Rejected).");
        }
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}