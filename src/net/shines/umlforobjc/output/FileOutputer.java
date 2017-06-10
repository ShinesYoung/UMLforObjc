package net.shines.umlforobjc.output;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import net.shines.kitbox.file.FileUtils;

public class FileOutputer extends BaseOutputer
{
	public enum PathType {
		AbsolutePath,
		RelativePath,
		FileName,
	}
	
	public void copyFile(File originFile, File fileCopy)
	{
		byte[] bContent = FileUtils.readBytesFromFile(originFile);
		
		FileUtils.writeToFile(fileCopy, bContent);
	}
	
	public void outputFileList(File outputFile, List<File> fileList, PathType pathType, boolean shwoFileSize)
	{
		fileList.sort(new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) 
			{
				return f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
			}
		});
		
		StringBuilder outputBuff = new StringBuilder();
		
		for (File aFile : fileList) 
		{
			if (pathType == PathType.AbsolutePath) {
				outputBuff.append(aFile.getAbsolutePath());
			} else if (pathType == PathType.RelativePath)  {
				outputBuff.append(aFile.getPath());
			} else if (pathType == PathType.FileName) {
				outputBuff.append(aFile.getName());
			}
			
			if (shwoFileSize) 
			{
				outputBuff.append(" (").append(aFile.length()/1000.0).append("k)");
			}
			outputBuff.append("\r\n");
		}
		
		String outputContent = outputBuff.toString();;
		FileUtils.writeToFile(outputFile, outputContent);
	}
}
