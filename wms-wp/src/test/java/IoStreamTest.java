import com.google.common.primitives.Bytes;
import org.apache.commons.lang.ArrayUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.CRC32;

/**
 * @author WP
 * @date 2018/12/20
 * @see [相关类/方法]（可选）
 * @Description IO字节流转化2、8、16进制学习
 */
public class IoStreamTest {
    
    static class AP{
        private String mac;
        private Long rssi;
        private Long channel;

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public Long getRssi() {
            return rssi;
        }

        public void setRssi(Long rssi) {
            this.rssi = rssi;
        }

        public Long getChannel() {
            return channel;
        }

        public void setChannel(Long channel) {
            this.channel = channel;
        }
    }
    
    public static void main(String[] args) throws IOException {
//        String temp = "欢迎来到bejson.com!";
//        System.out.println(getBytes(temp));
//        System.out.println(str2HexStr(temp));
//        System.out.println(hexStr2Str("E6ACA2E8BF8EE69DA5E588B062656A736F6E2E636F6D21"));


        List<AP> list = new ArrayList<AP>();
        AP ap1 = new AP();
        ap1.setMac("0008d2eaf9df");
        ap1.setRssi(-57L);
        ap1.setChannel(11L);
        AP ap2 = new AP();
        ap2.setMac("0008d2eaf9de");
        ap2.setRssi(-99L);
        ap2.setChannel(1L);
        AP ap3 = new AP();
        ap3.setMac("0008d2eac949");
        ap3.setRssi(-53L);
        ap3.setChannel(6L);
        list.add(ap1);
        list.add(ap2);
        list.add(ap3);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(bos);
        //消息头
		dos.writeByte(0xDB);
		dos.writeByte(0xDC);//magicNumber;
		dos.writeByte(0x16);//version;
		dos.writeLong(11111111111111111l);//token
		dos.write(getBytes("0008d2eac949"));
		dos.writeByte(1);//类型 1:ap
		dos.writeLong(new Date().getTime());
		dos.writeByte(3);
        //消息体
       for(AP ap:list){
//            byte[] t = getBytes(AP.getTime());
//            String a = new String(t,"utf-8");
//            dos.write(AP.getTime().getBytes());
//            dos.write(AP.getMac().getBytes());
//            dos.write(getBytes(AP.getTime()));
            dos.write(getBytes(ap.getMac()));
            dos.writeByte(ap.getRssi().intValue());
            dos.writeShort(ap.getChannel().intValue());
        }
        byte[] data = bos.toByteArray();
        String secretKey="2d5c5d50a7cd11e5b72152540007fa2f";
        CRC32 crc32=new CRC32();
        crc32.update(data);
        crc32.update(secretKey.getBytes());
        int signature= (int) crc32.getValue();
        dos.writeInt(signature);

        byte[] sendData=bos.toByteArray();

        /*byte[] stubMacByte = new byte[6];
        byte[] clientMacByte = new byte[6];
        byte[] rssiByte = new byte[2];
        System.arraycopy(sendData, 11, stubMacByte, 0, 6);
        System.arraycopy(sendData, 27, clientMacByte, 0, 6);
        System.arraycopy(sendData, 33, rssiByte, 0, 2);

        System.out.println(bytes2Mac(stubMacByte,6));
        System.out.println(bytes2Mac(clientMacByte,6));
        System.out.println(byte2short(rssiByte));*/


       int readSize;
        ByteArrayInputStream bis = new ByteArrayInputStream(sendData);
        DataInputStream dis =new DataInputStream(bis);

        List<Byte> byteList = new ArrayList<Byte>();
        // readBoolean till the data available to read
        while( dis.available() >0)
        {
            // read one single byte
            byte b = dis.readByte();
            System.out.print(b +" ");
            byteList.add(b);
        }
        List resList = byteList.subList(27, byteList.size() -4);
//        byte[] dataRes = Bytes.toArray(resList);
        byte[] dataRes = listTobyte(resList);

        int maxLen = 9, clientMacLen = 6, rssiLen = 1, channelLen = 2;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < dataRes.length/maxLen;i++){
            byte[] clientMac = new byte[clientMacLen];
            byte[] rssi = new byte[rssiLen];
            byte[] channel = new byte[channelLen];

            System.arraycopy(dataRes, i * maxLen, clientMac, 0, clientMacLen);
            System.arraycopy(dataRes, i * maxLen + clientMacLen, rssi, 0, rssiLen);
            System.arraycopy(dataRes, i * maxLen + clientMacLen + rssiLen, channel, 0, channelLen);
            res.append("\nMAC:" + bytes2Mac(clientMac, clientMacLen));
            res.append("\tRSSI:" + rssi[0]);
            res.append("\tCHANNEL:" + byte2short(channel) + "\n");
        }
        System.out.println(res.toString());
    }


    /**
     * 方法1，使用for循环
     * @param list
     * 将被转换为byte[]的List<Byte>
     * @return
     * 转换成的byte数组
     */
    private static byte[] listTobyte(List<Byte> list) {
        if (list == null || list.size() < 0)
            return null;
        byte[] bytes = new byte[list.size()];
        int i = 0;
        Iterator<Byte> iterator = list.iterator();
        while (iterator.hasNext()) {
            bytes[i] = iterator.next();
            i++;
        }
        return bytes;
    }

    /**
      * 字符串转换成为16进制(无需Unicode编码)
      * @param str
      * @return
      */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for(int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
      * 16进制直接转换成为字符串(无需Unicode解码)
      * @param hexStr
      * @return
      */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length()/2];
        int n;
        for(int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2* i]) * 16;
            n += str.indexOf(hexs[2* i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }


    public static String date2String(Date date) {
        return date2String(date, "yyyy-MM-dd");
    }

    public static String date2String(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = getDateFormat(format);
        return sdf.format(date);
    }

    public static SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    private static   byte[] getBytes(String mac){
        byte[] bytes=new byte[6];
        bytes[0]=hexString2byte(mac.substring(0,2));
        bytes[1]=hexString2byte(mac.substring(2,4));
        bytes[2]=hexString2byte(mac.substring(4,6));
        bytes[3]=hexString2byte(mac.substring(6,8));
        bytes[4]=hexString2byte(mac.substring(8,10));
        bytes[5]=hexString2byte(mac.substring(10,12));
        return bytes;
    }


    private static byte hexString2byte(String str){
        str = str.toUpperCase();//将字符串中的小写转化为大写
        char[] chars = str.toCharArray();
        byte b = (byte)((char2byte(chars[0]))<<4|char2byte(chars[1]));
        return b;
    }

    private  static byte char2byte(char c){
        return (byte)"0123456789ABCDEF".indexOf(c);//返回c中包含byte中数据的索引
    }

    private static String bytes2Mac(byte[] macBytes, int len){
        StringBuilder mac=new StringBuilder();
        String sTemp="";
        for(int i=0;i<len;i++){
            sTemp = Integer.toHexString(0xFF & macBytes[i]);
            if (sTemp.length() < 2) {
                mac.append("0");
            }
            mac.append(sTemp.toLowerCase());
        }
        return mac.toString();
    }

    // 打印byte对应的16进制的字符串
    private static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    // 打印char对应的16进制的字符串
    private static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    // 打印short对应的16进制的字符串
    private static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }

    public static short byte2short(byte[] b){
        short l = 0;
        for (int i = 0; i < 2; i++) {
            l<<=8; //<<=和我们的 +=是一样的，意思就是 l = l << 8
            l |= (b[i] & 0xff); //和上面也是一样的  l = l | (b[i]&0xff)
        }
        return l;
    }
}
