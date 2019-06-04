import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductArrayApplication {
    public static void main(String[] args){
        calculateProductArrayBasic(new long[]{5,1,4,2,3,12,56,100}); //Test 1
        calculateProductArrayBasic(new long[]{}); //Test 2
        calculateProductArrayBasic(new long[]{0}); //Test 3
        calculateProductArrayBasic(new long[]{1}); //Test 4
        calculateProductArrayBasic(new long[]{5,10}); //Test 5
        calculateProductArrayBasic(null); //Test 6
        calculateProductArrayBasic(new long[0]); //Test 7
        calculateProductArrayBasic(new long[]{3,0,23,0,64,0,0,1}); //Test 8
        calculateProductArrayBasic(new long[]{13,15,6,10,200,0,20,57}); //Test 9
        calculateProductArrayBasic(new long[]{10,31,5,0,0,45,34,10,50}); //Test 8
    }

    public static long[] calculateProductArrayBasic(long[] input){
        if(input!=null){
            if(input.length!=0){
                if(input.length==1){
                    if(input[0]==0){
                        System.out.print("Probando "+Arrays.toString(input));
                        input[0]=1;
                        System.out.print(" - Resultado "+Arrays.toString(input));
                        System.out.println();
                        return input;
                    }else{
                        System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
                        return input;
                    }
                }else {
                    List<Long> inputList=Arrays.stream(input).boxed().collect(Collectors.toList());
                    List<Long> result=new ArrayList<>();
                    List<Object> convertedList=new ArrayList<>();

                    for(int count=0;count<inputList.size();count++){
                        if(count>0){
                            convertedList.addAll(inputList.subList(0,count));
                        }
                        convertedList.addAll(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(count+1,input.length));



                        if(count!=inputList.size()-1){
                            convertedList.add("-");
                        }
                    }

                    for (Object aLista : convertedList) {
                        if (aLista instanceof Long) {
                            if (result.size() > 0) {
                                Long temp = result.get(result.size() - 1);
                                result.set(result.size() - 1, temp * (Long) aLista);
                            } else {
                                result.add((Long) aLista);
                            }
                        } else {
                            result.add(1L);
                        }
                    }

                    System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+result);
                    return result.stream().mapToLong(l -> l).toArray();
                }
            }else{
                System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
                return input;
            }
        }else{
            System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
            return input;
        }
    }
}
