package com.cnkl.fems.ticket;

public class TicketDecorators {

    //Component Interface
    public interface TicketPriceComponent {
        float getTotalPrice();
    }

    //Concrete Component
    public static class BaseTicketComponent implements TicketPriceComponent {

        private final Ticket ticket;

        public BaseTicketComponent(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        public float getTotalPrice() {
            return ticket.getTicketType().getTicketPrice(ticket.getFestival().getBaseTicketCost());
        }
    }

    //Abstract Decorator
    public static abstract class TicketDecorator implements TicketPriceComponent {

        protected final TicketPriceComponent component;

        public TicketDecorator(TicketPriceComponent component) {
            this.component = component;
        }

        @Override
        public float getTotalPrice() {
            return component.getTotalPrice();
        }
    }

    //Concrete Decorators

    //VIP Decorator
    public static class VIPDecorator extends TicketDecorator {

        private static final float VIP_SURCHARGE = 50.0f;

        public VIPDecorator(TicketPriceComponent component) {
            super(component);
        }

        @Override
        public float getTotalPrice() {
            return super.getTotalPrice() + VIP_SURCHARGE;
        }
    }
}
