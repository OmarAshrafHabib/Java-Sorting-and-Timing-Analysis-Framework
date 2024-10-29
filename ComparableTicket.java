import java.util.*;
/**
 * @author Omar Habib ID:3742418
 * represents a lottery ticket, with six numbers between 1 and 49
 */
public class ComparableTicket implements Comparable<ComparableTicket> {
    private static final int MAX_NUMBER = 49;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_QTY = 6;
    private int ticketId;
    private int[] numbers;  

    public ComparableTicket(int ticketId){
        this.ticketId = ticketId;
        numbers = new int[NUMBER_QTY];
        chooseRandomNumbers();
        Arrays.sort(numbers);
    }

    public int getTicketId(){
        return ticketId;
    }
        
    public int[] getNumbers(){
        return numbers;
    }

    public int compareTo(ComparableTicket other){
        if(this == other){
            return 0;
        }
        if(other == null){
            return 1;
        }
        if(ticketId == other.getTicketId()){
            return 0;
        }
        else if(ticketId < other.getTicketId()){
            return -1;
        }
        else{
            return 1;
        }
    }

    private void chooseRandomNumbers(){
        for(int i = 0; i< NUMBER_QTY; i++){
            int rand = (int)((Math.random()*NUMBER_QTY)+MIN_NUMBER);
            while(!duplicateNumber(i)){
                numbers[i] = (int)((Math.random()*MAX_NUMBER) + MIN_NUMBER);
                break;
            }
                
        }
    }

    private boolean duplicateNumber(int i){
        for(int j=0; j<i; j++){
            if(numbers[j] == numbers[i]){
                return true;
            }
        }
        return false;
    }

    public int countWinningNumbers(int[] winningNum){
        int counter = 0;
        for(int i = 0; i < NUMBER_QTY; i++){
            for(int j=0; j<NUMBER_QTY; j++){
                if(numbers[i] == winningNum[j])
                    counter++; 
            }
        }
        return counter;
    }

    public String toString(){
        String IdStr = Integer.toString(ticketId);
        String formattedTicketId = Util.padLeft(IdStr, 4);
        String formattedNumbers = "";

        for (int i = 0; i < NUMBER_QTY; i++) {
            String numberStr = Integer.toString(numbers[i]);
            String formattedNumber = Util.padLeft(numberStr, 3);
            formattedNumbers += formattedNumber;

            if (i < NUMBER_QTY - 1) {
                formattedNumbers += " ";
            }
        }

        return formattedTicketId + ": " + formattedNumbers;
    }

}