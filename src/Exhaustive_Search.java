import java.io.BufferedWriter;
import java.io.IOException;

public class Exhaustive_Search {
    public Exhaustive_Search(){

    }

    public void search(int currY, int currX, int startDecision, int level, StringBuilder movesSoFar, boolean[][] accessed, BufferedWriter fileState, BufferedWriter fileOut) throws IOException{
        movesSoFar.append(tileName(currY, currX));
        //System.out.println(level);
        if(level>62){
            System.out.println("FOUND SOLUTION");
            movesSoFar.append("\n");
            fileOut.write(movesSoFar.toString());
            movesSoFar.deleteCharAt(movesSoFar.length()-1);
            movesSoFar.deleteCharAt(movesSoFar.length()-1);
            movesSoFar.deleteCharAt(movesSoFar.length()-1);
            movesSoFar.deleteCharAt(movesSoFar.length()-1);
            return;
        }
        startDecision--;
        accessed[currY][currX] = true;
        
        while(startDecision < 7){
            startDecision ++;
            switch (startDecision){
                case 0:
                    if(boundsCheck(currY-2, currX-1) && !accessed[currY-2][currX-1]){
                        search(currY-2, currX-1, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    } 
                    break;
                case 1:
                    if(boundsCheck(currY-2, currX+1) && !accessed[currY-2][currX+1]){
                        search(currY-2, currX+1, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                case 2:
                    if(boundsCheck(currY-1, currX+2) && !accessed[currY-1][currX+2]){
                        search(currY-1, currX+2, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                case 3:
                    if(boundsCheck(currY+1, currX+2) && !accessed[currY+1][currX+2]){
                        search(currY+1, currX+2, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                case 4:
                    if(boundsCheck(currY-2, currX+1) && !accessed[currY-2][currX+1]){
                        search(currY-2, currX+1, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                case 5:
                    if(boundsCheck(currY-2, currX-1) && !accessed[currY-2][currX-1]){
                        search(currY-2, currX-1, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                case 6:
                    if(boundsCheck(currY-1, currX-2) && !accessed[currY-1][currX-2]){
                        search(currY-1, currX-2, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;
                default:
                    if(boundsCheck(currY+1, currX-2) && !accessed[currY+1][currX-2]){
                        search(currY+1, currX-2, 0, level+1, movesSoFar, accessed, fileState, fileOut);
                    }
                    break;

            

            }

        }
        accessed[currY][currX] = false;
        movesSoFar.deleteCharAt(movesSoFar.length()-1);
        movesSoFar.deleteCharAt(movesSoFar.length()-1);
        movesSoFar.deleteCharAt(movesSoFar.length()-1);
        return;
    }
    public static boolean boundsCheck(int y, int x){
        return y < 8 && x < 8 && x >= 0 && y >= 0;
    }   
    public static String tileName(int y, int x){
        char yOut= 'A';
        yOut+=y;
        char xOut= '1';
        xOut+=x;
        return new StringBuilder().append(yOut).append(xOut).append(",").toString();
    }  
}
