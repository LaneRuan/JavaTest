package algorithm;
/*
将:\java目录下的所有.java文件复制到:\jad目录下，
并将原来文件的扩展名从.java改为.jad。
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaCast2Jad {
    public static void main(String[] args) throws Exception {
        File srcDir =new File("java");
        if(!(srcDir.exists()&& srcDir.isDirectory()))
            throw new IOException("目录不存在");
        File[] files= srcDir.listFiles(new FilenameFilter(){
            //listFiles方法接受一个FileFilter对象，
            //这个FileFilter对象就是过虑的策略对象,
            //不同的人提供不同的FileFilter实现，
            //即提供了不同的过滤策略。
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(files.length);
        File destDir= new File("jad");
        if(!destDir.exists())
            destDir.mkdir();
        for(File f:files){
            FileInputStream fis = new FileInputStream(f);
            String destFileName = f.getName().replaceAll("\\.java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir,destFileName));
            copy(fis,fos);
            fis.close();
            fos.close();
        }
    }
    private static void copy(InputStream ips, OutputStream ops) throws Exception{
        int len = 0;
        byte[] buf =new byte[1024];
        while((len =ips.read(buf)) != -1){
            ops.write(buf,0,len);
        }
    }
}