//package com.example.demo.TDD;
//
//import lombok.extern.log4j.Log4j2;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//@Log4j2
//public class tttttt {
//
//    @Test
//    public void main() {
//        String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
//
//        solution(record);
//    }
//
//    int[] answer = new int[2];
//    ArrayList<Good> incomeGoodList = new ArrayList<>();
//
//    private class Good {
//        private int price;
//        private int qty;
//
//        public Good(int price, int qty) {
//            this.price = price;
//            this.qty = qty;
//        }
//    }
//
//    public void firstOutCostOfSalesCalc(String[] record) {
//        String[] goodCommandInfo;
//        int totalCostOfSales = 0;
//
//        for (int i = 0; i<record.length; i++) {
//            goodCommandInfo = record[i].split("\\s+");
//            String command = goodCommandInfo[0];
//            int price = Integer.parseInt(goodCommandInfo[1]);
//            int qty   = Integer.parseInt(goodCommandInfo[2]);
//
//            if ("P".equals(command)) {
//                incomeGoodList.add(new Good(price, qty));
//            } else {
//                int index = 0;
//
//                while (qty > 0) {
//                    int incomeQty = incomeGoodList.get(index).qty;
//                    int incomePrice = incomeGoodList.get(index).price;
//
//                    if (incomeQty == 0) {
//                        index++;
//                        continue;
//                    }
//
//                    if (incomeQty > qty) {
//                        totalCostOfSales += qty * incomePrice;
//                        incomeQty = incomeQty - qty;
//                        qty = 0;
//                        incomeGoodList.get(index).qty = incomeQty;
//                    } else {
//                        totalCostOfSales += incomeQty * incomePrice;
//                        qty = qty - incomeQty;
//                        incomeQty = 0;
//                        incomeGoodList.get(index).qty = 0;
//                    }
//
//                    index++;
//                }
//            }
//        }
//
//        answer[0] = totalCostOfSales;
//    }
//
//    public void lastOutCostOfSalesCalc(String[] record) {
//        String[] goodCommandInfo;
//        int totalCostOfSales = 0;
//
//        for (int i = 0; i<record.length; i++) {
//            goodCommandInfo = record[i].split("\\s+");
//            String command = goodCommandInfo[0];
//            int price = Integer.parseInt(goodCommandInfo[1]);
//            int qty   = Integer.parseInt(goodCommandInfo[2]);
//
//            if ("P".equals(command)) {
//                incomeGoodList.add(new Good(price, qty));
//            } else {
//                int index = incomeGoodList.size() - 1;
//
//                while (qty > 0) {
//                    int incomeQty = incomeGoodList.get(index).qty;
//                    int incomePrice = incomeGoodList.get(index).price;
//
//                    if (incomeQty > qty) {
//                        totalCostOfSales += qty * incomePrice;
//                        incomeQty = incomeQty - qty;
//                        qty = 0;
//                        incomeGoodList.get(index).qty = incomeQty;
//                    } else {
//                        totalCostOfSales += incomeQty * incomePrice;
//                        qty = qty - incomeQty;
//                        incomeQty = 0;
//                        incomeGoodList.remove(index);
//                    }
//
//                    index--;
//                }
//            }
//        }
//
//        answer[1] = totalCostOfSales;
//    }
//
//    public int[] solution(String[] record) {
//        firstOutCostOfSalesCalc(record);
//        lastOutCostOfSalesCalc(record);
//        return answer;
//    }
//
//}
