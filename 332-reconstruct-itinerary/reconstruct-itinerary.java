class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
       
       Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
           
            String src = ticket.get(0);
           
            String des = ticket.get(1);

            if (!graph.containsKey(src)) {
                graph.put(src, new PriorityQueue<String>());
            }
            graph.get(src).offer(des);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);

        return itinerary;

    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph,
        LinkedList<String> itinerary) {
                        
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {

            String nextAirport = destinations.poll();

            dfs (nextAirport, graph, itinerary);
        }

        itinerary.addFirst(airport);

                    }
    }   

