package task_1.by.epam.andrewzenov.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ReadWriteUtil {

	public static String readFile(String pathName) {

		StringBuilder result = new StringBuilder();
		String str;
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(pathName)))) {
			while ((str = buf.readLine()) != null) {
				result.append(str);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result.toString();
	}

	public static byte[] readFile(String patnName, String charsetName) {
		byte[] result = null;
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(patnName)))) {
			result = buf.readLine().getBytes(charsetName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static boolean writeFile(String pathName, String source) {

		boolean result = false;

		try (FileWriter out = new FileWriter(new File(pathName))) {
			out.write(source);
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static boolean writeFile(String pathName, byte[] source, String charsetName) {

		boolean result = false;

		try (OutputStream outputStream = new FileOutputStream(new File(pathName));
				Writer outputStreamWriter = new OutputStreamWriter(outputStream, charsetName);) {
			outputStream.write(source);
			result = true;
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void convert(
		    String infile, //input file name, if null reads from console/stdin
		    String outfile, //output file name, if null writes to console/stdout
		    String from,   //encoding of input file (e.g. UTF-8/windows-1251, etc)
		    String to)     //encoding of output file (e.g. UTF-8/windows-1251, etc)
		        throws IOException, UnsupportedEncodingException
		{
		    // set up byte streams
		    InputStream in;
		    if(infile != null)
		        in=new FileInputStream(infile);
		    else
		        in=System.in;
		    OutputStream out;
		    if(outfile != null)
		        out=new FileOutputStream(outfile);
		    else
		        out=System.out;

		    // Use default encoding if no encoding is specified.
		    if(from == null) from=System.getProperty("file.encoding");
		    if(to == null) to=System.getProperty("file.encoding");

		    // Set up character stream
		    Reader r=new BufferedReader(new InputStreamReader(in, from));
		    Writer w=new BufferedWriter(new OutputStreamWriter(out, to));

		    // Copy characters from input to output.  The InputStreamReader
		    // converts from the input encoding to Unicode,, and the OutputStreamWriter
		    // converts from Unicode to the output encoding.  Characters that cannot be
		    // represented in the output encoding are output as '?'
		    char[] buffer=new char[4096];
		    int len;
		    while((len=r.read(buffer)) != -1)
		        w.write(buffer, 0, len);
		    r.close();
		    w.flush();
		    w.close();
		}
	
}
