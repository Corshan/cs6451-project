package com.cnkl.fems.festival;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.customer.CustomerRepository;
import com.cnkl.fems.festival.state.ClosedState;
import com.cnkl.fems.festival.state.OpenState;
import com.cnkl.fems.ticket.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FestivalServiceTest {

    @Mock
    private FestivalRepository festivalRepository;
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private FestivalService festivalService;

    private Festival mockFestival1;
    private Festival mockFestival2;
    private Festival mockFestival3;

    private Customer mockCustomer1;

    private Ticket mockTicket1;

    @BeforeEach
    void setUp() {
        mockFestival1 = new Festival(1L, "All Together Now", 10f, 100);
        mockFestival2 = new Festival(2L, "Electric Picnic", 10f, 100);
        mockFestival3 = new Festival(3L, "Glastonbury", 10f, 100);
        mockCustomer1 = new Customer(1L, "Corey Shanahan", new Date(), "0834837755", "corey@example.com");
        mockTicket1 = new Ticket(1L, mockFestival1, mockCustomer1, TicketTypes.BASE);
    }

    @AfterEach
    void tearDown() {
        mockFestival1 = null;
        mockFestival2 = null;
        mockFestival3 = null;
        mockCustomer1 = null;
        mockTicket1 = null;
    }

    @Test
    void shouldReturnFestivalById(){

        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));

        Festival festival = festivalService.getFestivalById(1L).get();

        assertEquals(1L, festival.getId());
        assertEquals("All Together Now", festival.getName());
        assertEquals(10f, festival.getBaseTicketCost());
        assertEquals(100, festival.getTotalTickets());
    }

    @Test
    void shouldChangeStateToOpen(){
        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));

        assertInstanceOf(ClosedState.class, mockFestival1.getFestivalState());

        festivalService.openFestival(1L);

        assertInstanceOf(OpenState.class, mockFestival1.getFestivalState());
    }

    @Test
    void changeStateToOpenShouldThrowExceptionWhenFestivalDoesNotExist(){
        assertThrows(RuntimeException.class, () -> {
           festivalService.openFestival(1L);
        });
    }

    @Test
    void shouldChangeStateToClosed(){
        mockFestival1.setStateOpen();

        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));

        assertInstanceOf(OpenState.class, mockFestival1.getFestivalState());

        festivalService.closeFestival(1L);

        assertInstanceOf(ClosedState.class, mockFestival1.getFestivalState());
    }

    @Test
    void changeStateToClosedShouldThrowExceptionWhenFestivalDoesNotExist(){
        assertThrows(RuntimeException.class, () -> {
            festivalService.closeFestival(1L);
        });
    }

    @Test
    void shouldReturnListOfFestivals(){
        List<Festival> mockFestivals = Stream.of(mockFestival1, mockFestival2, mockFestival3).toList();
        List<FestivalDto> mockFestivalDto = mockFestivals.stream().map(FestivalMapper::toDto).toList();
        when(festivalRepository.findAll()).thenReturn(mockFestivals);

        List<FestivalDto> festivalDtos = festivalService.getAllFestivals();

        assertTrue(festivalDtos.containsAll(mockFestivalDto));
    }

    @Test
    void shouldReturnAnEmptyList(){
        when(festivalRepository.findAll()).thenReturn(new ArrayList<>());

        List<FestivalDto> festivals = festivalService.getAllFestivals();

        assertTrue(festivals.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenFestivalDoesNotExist(){
        assertThrows(RuntimeException.class, () -> {
           festivalService.purchaseTicket(0,0);
        });
    }

    @Test
    void shouldThrowExceptionWhenCustomerDoesNotExist(){
        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));

        assertThrows(RuntimeException.class, () -> {
            festivalService.purchaseTicket(1L,0);
        });
    }

    @Test
    void shouldThrowExceptionWhenFestivalIsClosed(){
        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));
        when(customerRepository.findById(1L)).thenReturn(Optional.of(mockCustomer1));

        assertThrows(RuntimeException.class, () -> {
            festivalService.purchaseTicket(1L,1L);
        });
    }

    @Test
    void shouldReturnTicketDto(){
        when(festivalRepository.findById(1L)).thenReturn(Optional.of(mockFestival1));
        when(customerRepository.findById(1L)).thenReturn(Optional.of(mockCustomer1));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(mockTicket1);

        mockFestival1.setStateOpen();

        TicketDto dto = festivalService.purchaseTicket(1L, 1L);

        assertEquals(1L, dto.getId());
        assertEquals(1L, dto.getCustomer_id());
        assertEquals(1L, dto.getFestival_id());
    }
}