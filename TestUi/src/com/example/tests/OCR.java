package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OCR {
	private final String LANG_OPTION = "-l";// 英文小写字母l,非数字1
	// private final String EOL ="";
	private final String EOL = System.getProperty("line.separator");
	private String tessPath = "C://Program Files (x86)//Tesseract-OCR";

	public String recognizeText(File imageFile, String imageFormat) {
		File tempImage = ImageHelp.createImage(imageFile, imageFormat);

		File outputFile = new File(imageFile.getParentFile(), "output"
				+ imageFile.getName());

		StringBuffer sb = new StringBuffer();
		List<String> cmd = new ArrayList<String>();

		cmd.add(tessPath + "//tesseract");
		cmd.add("");
		cmd.add(outputFile.getName());
		cmd.add(LANG_OPTION);// 设置语言属性
		cmd.add("eng");
		// cmd.add("chi_sim");
		ProcessBuilder pb = new ProcessBuilder();

		pb.directory(imageFile.getParentFile());
		cmd.set(1, "1.jpg");

		pb.command(cmd);
		pb.redirectErrorStream(true);

		Process process = null;
		BufferedReader in = null;
		int wait;
		// 关于采用OCR技术相关命名
		// Usage:tesseract.exe imagename outputbase [-l lang] [-psm pagesegmode]
		// [configfile...]
		//tesseract i.imag 1 -l chi_sim(语言)
		// pagesegmode values are:
		// 0 = Orientation and script detection (OSD) only.
		// 1 = Automatic page segmentation with OSD.
		// 2 = Automatic page segmentation, but no OSD, or OCR
		// 3 = Fully automatic page segmentation, but no OSD. (Default)
		// 4 = Assume a single column of text of variable sizes.
		// 5 = Assume a single uniform block of vertically aligned text.
		// 6 = Assume a single uniform block of text.
		// 7 = Treat the image as a single text line.
		// 8 = Treat the image as a single word.
		// 9 = Treat the image as a single word in a circle.
		// 10 = Treat the image as a single character.
		// -l lang and/or -psm pagesegmode must occur before anyconfigfile.
		try {
			process = pb.start();
			// tesseract.exe xxx.tif 1 -l eng
			wait = process.waitFor();

			if (wait == 0) {
				in = new BufferedReader(new InputStreamReader(
						new FileInputStream(outputFile.getAbsolutePath()
								+ ".txt"), "UTF-8"));
				String str;
				while ((str = in.readLine()) != null) {
					System.out.println(str);
					sb.append(str).append(EOL);
				}
				in.close();

			} else {
				String msg;
				switch (wait) {
				case 1:
					msg = "Errors accessing files.There may be spaces in your image's filename.";
					break;
				case 29:
					msg = "Cannot recongnize the image or its selected region.";
					break;

				case 31:
					msg = "Unsupported image format.";
					break;
				default:
					msg = "Errors occurred.";
				}

				tempImage.delete();
				// throw new RuntimeException(msg);
			}
			new File(outputFile.getAbsolutePath() + ".txt").delete();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		tempImage.delete();
		return sb.toString();
	}

	public static void main(String[] args) {
		String path = "F://Auto//work//TestUi//conf//1.jpg";
		System.out.println("ORC Test Begin......");
		try {
			String valCode = new OCR().recognizeText(new File(path), "jpg");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ORC Test End......");
	}
}