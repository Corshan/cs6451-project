package com.cnkl.fems.festival;

import com.cnkl.fems.customer.CustomerRepository;
import com.cnkl.fems.festival.state.ClosedState;
import com.cnkl.fems.festival.state.OpenState;
import com.cnkl.fems.ticket.TicketMapper;
import com.cnkl.fems.ticket.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
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

    @BeforeEach
    void setUp() {
        mockFestival1 = new Festival(1L, "All Together Now", 10f, 100);
        mockFestival2 = new Festival(2L, "Electric Picnic", 10f, 100);
        mockFestival3 = new Festival(3L, "Glastonbury", 10f, 100);
    }

    @AfterEach
    void tearDown() {
        mockFestival1 = null;
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
}