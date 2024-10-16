package cn.afuo.example.txt;


import cn.afuo.common.util.JsonUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TxtReaderMain {

    public static void main(String[] args) {

        String filePath = "/Users/tianci/Documents/文档-代码常用/test1.txt"; // 设置你的文件路径
        int sum =0;
        int notZero = 0;
        int zero = 0;
        List<String> orderNoList = new ArrayList<>();
        Set<String> orderNoSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String orderNo = "";
                if (line.contains("soOrderNum")) {
                    int soOrderNumIndex = line.indexOf("soOrderNum");
                    String soOrderNumAfterStr = line.substring(soOrderNumIndex);
                    int soOrderNumAfterIndex = soOrderNumAfterStr.indexOf(",");
                    orderNo = soOrderNumAfterStr.substring("soOrderNum\":".length() + 1, soOrderNumAfterIndex - 1);
                }
                if (line.contains("riskReserveFee")) {
                    int riskReserveFeeIndex = line.indexOf("riskReserveFee");
                    String riskReserveFeeAfterStr = line.substring(riskReserveFeeIndex);
                    int soOrderNumAfterIndex = riskReserveFeeAfterStr.indexOf(",");
                    String result = riskReserveFeeAfterStr.substring("riskReserveFee\":".length(), soOrderNumAfterIndex);
                    if (result.equals("0")) {
                        zero++;
                        orderNoList.add(orderNo);
                        orderNoSet.add(orderNo);
                    } else {
                        notZero++;
                    }
                    sum++;
                }
            }
            System.out.println("总单号数量：" + sum);
            System.out.println("风险金推送是0数量：" + zero);
            System.out.println("风险金推送不是0数量：" + notZero);
            System.out.println("风险金推送集合是0数量：" + orderNoList.size());
            System.out.println("风险金推送集合是0数量去重：" + orderNoSet.size() + ",订单号是：" + JsonUtil.toJson(orderNoSet));

            List<String> orderNoSetContainsSqlOrderNoList = new ArrayList<>();
            List<String> sqlOrderNoContainsOrderNoSetList = new ArrayList<>();
            List<String> sqlOrderNoNotContainsOrderNoSetList = new ArrayList<>();
            String sqlOrderNo = "SO241006100028,SO241004130042,SO241001130031,SO241001130025,SO240929170076,SO240928180012,SO240928090051,SO240927140046,SO240927110003,SO240926110061,SO240925160138,SO240924170086,SO240924160175,SO240924160123,SO240924150150,SO240924150108,SO240924150052,SO240924100006,SO240923180069,SO240923150062,SO240923140045,SO240922190031,SO240922150067,SO240921210004,SO240921170011,SO240921160074,SO240920180068,SO240920150121,SO240920140011,SO240920120011,SO240919230005,SO240919220003,SO240919170090,SO240919160038,SO240919110138,SO240919100048,SO240919090137,SO240919090009,SO240919090008,SO240918160083,SO240918140048,SO240918120005,SO240918110059,SO240917190016,SO240917190014,SO240917170011,SO240917110051,SO240917110011,SO240916200006,SO240916190013,SO240916150072,SO240916110123,SO240915160125,SO240915160072,SO240915120049,SO240915090074,SO240915090020,SO240914200025,SO240914100081,SO240914090060,SO240913170016,SO240913160070,SO240913140140,SO240912180066,SO240912180006,SO240912150144,SO240912140147,SO240912130025,SO240912110123,SO240912100137,SO240912100087,SO240911160059,SO240911160041,SO240911120028,SO240911100078,SO240911100041,SO240911090019,SO240910190090,SO240910180082,SO240910110089,SO240910100093,SO240909200003,SO240909160034,SO240909130017,SO240909100021,SO240908180076,SO240908120035,SO240908110020,SO240908090056,SO240907180099,SO240907080033,SO240907080007,SO240906180261,SO240906180173,SO240906180138,SO240906180134,SO240906180099,SO240906180090,SO240906180043,SO240906160093,SO240906120077";
            List<String> sqlOrderNoList = Arrays.asList(sqlOrderNo.split(","));
            System.out.println("sql查出易购已交车数量：" + sqlOrderNoList.size());
            for (String orderNo : sqlOrderNoList) {
                if (orderNoSet.contains(orderNo)) {
                    orderNoSetContainsSqlOrderNoList.add(orderNo);
                } else {
                    System.out.println("sql循环判断日志不包含：" + orderNo);
                }
            }
            for (String orderNo : orderNoSet) {
                if (sqlOrderNoList.contains(orderNo)) {
                    sqlOrderNoContainsOrderNoSetList.add(orderNo);
                } else {
                    sqlOrderNoNotContainsOrderNoSetList.add(orderNo);
                }
            }
            // 反转列表
            orderNoSetContainsSqlOrderNoList.sort(Comparator.reverseOrder());
            sqlOrderNoContainsOrderNoSetList.sort(Comparator.reverseOrder());
            sqlOrderNoNotContainsOrderNoSetList.sort(Comparator.reverseOrder());
            System.out.println("sql循环判断日志包含：" + orderNoSetContainsSqlOrderNoList.size() + "," + JsonUtil.toJson(orderNoSetContainsSqlOrderNoList));
            System.out.println("日志循环判断sql包含：" + sqlOrderNoContainsOrderNoSetList.size() + "," + JsonUtil.toJson(sqlOrderNoContainsOrderNoSetList));
            System.out.println("日志循环判断sql不包含：" + sqlOrderNoNotContainsOrderNoSetList.size() + "," + JsonUtil.toJson(sqlOrderNoNotContainsOrderNoSetList));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
