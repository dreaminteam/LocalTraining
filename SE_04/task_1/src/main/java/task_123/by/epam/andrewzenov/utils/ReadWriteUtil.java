package task_123.by.epam.andrewzenov.utils;

import java.io.*;

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

	public static boolean convert(String infile, String outfile, String encodingInputFile, String encodingOutputFile) {
		boolean result = false;
		try (InputStream in = new FileInputStream(infile);
				OutputStream out = new FileOutputStream(outfile);
				Reader r = new BufferedReader(new InputStreamReader(in, encodingInputFile));
				Writer w = new BufferedWriter(new OutputStreamWriter(out, encodingOutputFile));) {

			char[] buffer = new char[4096];
			int len;
			while ((len = r.read(buffer)) != -1)
				w.write(buffer, 0, len);
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
