package com.stack.common.messages;

import com.stack.common.model.Route;
import com.stack.common.model.Source;
import com.stack.common.model.Type;

public class OfficeRouteMessage extends Message {
    private Route route;

    public OfficeRouteMessage() {
        this.source = Source.OFFICE;
        this.type = Type.ROUTE;
    }

    public OfficeRouteMessage(Route route) {
        this();
        this.route = route;
    }
}
