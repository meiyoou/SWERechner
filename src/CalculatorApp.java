import java.util.*;

// Entry Point of our App
class CalculatorApp{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in); // For taking inputs from User
        int option;                         // Variable to store selected Operation Type
        double num1,num2;                   // Variables to Store Input Numbers

        do{
            System.out.print("\nBitte wählen Sie eine Rechenoperation aus:\n");

            System.out.printf("%s\t%s\n","1", "Addition");
            System.out.printf("%s\t%s\n","2", "Subtraktion");
            System.out.printf("%s\t%s\n","3", "Multiplikation");
            System.out.printf("%s\t%s\n","4", "Division");
            System.out.printf("%s\t%s\n","5", "Potenzieren");
            System.out.printf("%s\t%s\n","6", "Quadratwurzel");
            System.out.printf("%s\t%s\n","0", "Beenden");

            try{
                option=sc.nextInt();
            }catch(InputMismatchException e){
                System.err.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                continue;
            }

            switch(option){
                case 1:{
                    System.out.print("\nGeben Sie die erste Zahl ein: ");
                    num1 = sc.nextDouble();
                    System.out.print("\nGeben Sie die zweite Zahl ein: ");
                    num2 = sc.nextDouble();
                    double result = AdditionOperation.addNumbers(num1,num2);
                    if((result % 1) == 0 ){
                        System.out.printf("\nErgebnis der Addition von %d und %d ist: %d \n",(int)num1,(int)num2,(int)result);
                    }else{
                        System.out.printf("\nErgebnis der Addition von %f und %f ist: %f \n",num1,num2,result);
                    }
                    break;
                }
                case 2:{
                    System.out.print("\nGeben Sie die erste Zahl ein: ");
                    num1 = sc.nextDouble();
                    System.out.print("\nGeben Sie die zweite Zahl ein: ");
                    num2 = sc.nextDouble();
                    double result = SubstractionOperation.substractNumber(num1,num2);
                    if((result % 1) == 0 ){
                        System.out.printf("\nErgebnis der Subtraktion von %d und %d ist: %d \n",(int)num1,(int)num2,(int)result);
                    }else{
                        System.out.printf("\nErgebnis der Subtraktion von %f und %f ist: %f \n",num1,num2,result);
                    }
                    break;
                }
                case 3:{
                    System.out.print("\nGeben Sie die erste Zahl ein: ");
                    num1 = sc.nextDouble();
                    System.out.print("\nGeben Sie die zweite Zahl ein: ");
                    num2 = sc.nextDouble();
                    double result = MultiplyOperation.multiplyNumbers(num1,num2);
                    if((result % 1) == 0 ){
                        System.out.printf("\nErgebnis der Multiplikation von %d und %d ist: %d \n",(int)num1,(int)num2,(int)result);
                    }else{
                        System.out.printf("\nErgebnis der Multiplikation von %f und %f ist: %f \n",num1,num2,result);
                    }
                    break;
                }
                case 4:{
                    System.out.print("\nGeben Sie den Dividenden ein: ");
                    num1 = sc.nextDouble();
                    System.out.print("\nGeben Sie den Divisor ein: ");
                    num2 = sc.nextDouble();
                    double result = DivideOperation.divideNumbers(num1,num2);
                    if((result % 1) == 0 ){
                        System.out.printf("\nDas Ergebnis der Division von %d durch %d ist: %d \n",(int)num1,(int)num2,(int)result);
                    }else{
                        System.out.printf("\nDas Ergebnis der Division von %f durch %f ist: %f \n",num1,num2,result);
                    }
                    break;
                }
                case 5:{
                    System.out.print("\nGeben Sie die Basis ein: ");
                    num1 = sc.nextDouble();
                    System.out.print("\nGeben Sie die Potenz ein: ");
                    num2 = sc.nextDouble();
                    double result = ExponentiationOperation.exponentiateNumbers(num1,num2);
                    if((result % 1) == 0 ){
                        System.out.printf("\nDas Ergebnis des Potenzierens von %d mit %d ist: %d \n",(int)num1,(int)num2,(int)result);
                    }else{
                        System.out.printf("\nDas Ergebnis des Potenzierens von %f mit %f ist: %f \n",num1,num2,result);
                    }
                    break;
                }
                case 6:{
                    System.out.print("\nGeben Sie die Radikant ein: ");
                    num1 = sc.nextDouble();
                    double result = SquareRootOperation.squareRootOf(num1);
                    if((result % 1) == 0 ){
                        System.out.printf("\nDie Quadratwurzel von %d ist: %d \n",(int)num1,(int)result);
                    }else{
                        System.out.printf("\nDie Quadratwurzel von %f ist: %f \n",num1,result);
                    }
                    break;
                }
                default :
                    System.exit(0);
            }
        }while(true);
    }
}