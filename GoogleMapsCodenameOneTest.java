      public void start(){
        Form hi = new Form("Google Direction Service");
        
        final GoogleMap map = new GoogleMap();
        hi.setLayout(new BorderLayout());
        
        final TextField start = new TextField();
        start.setHint("Start location");
        
        
        final TextField end = new TextField();
        end.setHint("Destination");
        
        Container form = new Container();
        form.setLayout(new BorderLayout());
        form.addComponent(BorderLayout.NORTH, start);
        form.addComponent(BorderLayout.SOUTH, end);
        
        ActionListener routeListener = new ActionListener(){

            public void actionPerformed(ActionEvent evt) {
                if ( !"".equals(start.getText()) && !"".equals(end.getText())){
                    DirectionsRequest req = new DirectionsRequest();
                    req.setTravelMode(DirectionsRequest.TRAVEL_MODE_DRIVING);
                    req.setOriginName(start.getText());
                    req.setDestinationName(end.getText());
                    map.route(req, new DirectionsRouteListener(){

                        public void routeCalculated(DirectionsResult result) {
                            System.out.println("Successfully mapped route");
                        }
                        
                    });
                }
            }
            
        };
        
        start.addActionListener(routeListener);
        end.addActionListener(routeListener);
        
        hi.addComponent(BorderLayout.NORTH, form);
        
        hi.addComponent(BorderLayout.CENTER, map);
        hi.show();
        
    }
    