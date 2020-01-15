package scf.assignment1;

public class JobScheduler {
    
    /**
     * stores objects of Process
     * see Process class below
     */
    private Process[] processes;
    
    /**
     * stores average waiting time of processes.
     */
    private double averageWaitingTime;
    
    /**
     * stores maximum waiting time of a process in queue.
     */
    private int maximumWaitingTime;
    
    /**
     * Only constructor which initiates all the Process
     * objects and corresponding details.
     * @param arrivalAndBurstTime
     */
    JobScheduler(int[][] arrivalAndBurstTime) {
        processes = new Process[arrivalAndBurstTime.length];
        int[] processIds = new int[arrivalAndBurstTime.length];
        for (int i = 0; i < arrivalAndBurstTime.length; i++) {
            processes[i] = new Process();
            processIds[i] = i;
            processes[i].processId = i;
            processes[i].arrivalTime = arrivalAndBurstTime[i][0];
            processes[i].burstTime = arrivalAndBurstTime[i][1];
        }
        
        if (processes.length == 0) {
            return;
        }
        
        // sort process ids in processIds array 
        // ascending order of their arrival times
        for (int i = 0; i < processIds.length - 1; i++) {
            for (int j = 0; j < processIds.length - i - 1; j++) {
                if (processes[processIds[j]].arrivalTime > 
                        processes[processIds[j + 1]].arrivalTime) {
                    int id = processIds[j];
                    processIds[j] = processIds[j + 1];
                    processIds[j + 1] = id;
                }
            }
        }
        
        // set start times of all processes.
        processes[processIds[0]].startTime =
                    processes[processIds[0]].arrivalTime;
        for (int i = 1; i < processIds.length; i++) {
            int time = processes[processIds[i - 1]].startTime +
                       processes[processIds[i - 1]].burstTime;
            processes[processIds[i]].startTime =
                    Math.max(time, processes[processIds[i]].arrivalTime);
        }
        
        // setting completion time, turnaround time and waiting time
        for (int i = 0; i < processes.length; i++) {
            processes[i].completionTime =
                    processes[i].startTime + processes[i].burstTime;
            processes[i].turnaroundTime =
                    processes[i].completionTime - processes[i].arrivalTime;
            processes[i].waitingTime =
                    processes[i].turnaroundTime - processes[i].burstTime;
        }
        
        // calculating average and maximum waiting time
        averageWaitingTime = 0;
        maximumWaitingTime = 0;
        for (int i = 0; i < processes.length; i++) {
            averageWaitingTime += processes[i].waitingTime;
            if (processes[i].waitingTime > maximumWaitingTime) {
                maximumWaitingTime = processes[i].waitingTime;
            }
        }
        averageWaitingTime /= (double) processes.length;
    }
    
    /**
     * return array denoting completion times of processes
     * in the order given to the class.
     * @return
     */
    public int[] getCompletionTimes() {
        int[] completionTimes = new int[processes.length];
        for (int i = 0; i < processes.length; i++) {
            completionTimes[i] = processes[i].completionTime;
        }
        return completionTimes;
    }
    
    /**
     * return array denoting turnaround times of processes
     * in the order given to the class.
     * @return
     */
    public int[] getTurnaroundTimes() {
        int[] turnaroundTimes = new int[processes.length];
        for (int i = 0; i < processes.length; i++) {
            turnaroundTimes[i] = processes[i].turnaroundTime;
        }
        return turnaroundTimes;
    }
    
    /**
     * return array denoting waiting times of processes
     * in the order given to the class.
     * @return
     */
    public int[] getWaitingTimes() {
        int[] waitingTimes = new int[processes.length];
        for (int i = 0; i < processes.length; i++) {
            waitingTimes[i] = processes[i].waitingTime;
        }
        return waitingTimes;
    }
    
    /**
     * It returns average waiting time of processes.
     * @return
     */
    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }
    
    /**
     * It returns maximum waiting time of a process in queue.
     * @return
     */
    public int getMaximumWaitingTime() {
        return maximumWaitingTime;
    }
    
    public void displayAllDetails() {
        System.out.println(String.format("%-15s %-15s %-15s %-15s "
                                        + "%-15s %-15s %-15s",
                                        "Process Id",
                                        "Arrival Time",
                                        "Burst Time",
                                        "Start Time",
                                        "Completion Time",
                                        "Turnaround Time",
                                        "Waiting Time"));
        
        for (int i = 0; i < processes.length; i++) {
            System.out.println(String.format("%-15s %-15s %-15s %-15s "
                                            + "%-15s %-15s %-15s",
                                            processes[i].processId,
                                            processes[i].arrivalTime,
                                            processes[i].burstTime,
                                            processes[i].startTime,
                                            processes[i].completionTime,
                                            processes[i].turnaroundTime,
                                            processes[i].waitingTime));
        }
        
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Maximum Waiting Time: "+ maximumWaitingTime);
    }
    
    private class Process {
        int processId;
        int arrivalTime;
        int burstTime;
        int startTime;
        int completionTime;
        int turnaroundTime;
        int waitingTime;
    }
}