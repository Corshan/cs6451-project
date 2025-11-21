package com.cnkl.fems.ticket;

public enum TicketTypes {
    BASE {
        @Override
        public float getTicketPrice(float baseCost) {
            return baseCost;
        }
    },
    CHILD {
        @Override
        public float getTicketPrice(float baseCost) {
            return 0.0f;
        }
    },
    SENIOR {
        @Override
        public float getTicketPrice(float baseCost) {
            return baseCost * (1 -0.10f);
        }
    },
    STUDENT {
        @Override
        public float getTicketPrice(float baseCost) {
            return baseCost * (1 - 0.15f);
        }
    };

    public abstract float getTicketPrice(float baseCost);

}