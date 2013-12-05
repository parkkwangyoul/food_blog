<%@ page import="java.io.*" %>
<%@ include file="config.jsp" %>
<%
String contentType = request.getContentType();

if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
{
    DataInputStream in = new DataInputStream(request.getInputStream());

    // ������ ��ü ����
    int contentLength = request.getContentLength();

    byte dataBytes[] = new byte[contentLength];
    int byteRead = 0;
    int totalBytesRead = 0;

    while (totalBytesRead < contentLength) {
        byteRead = in.read(dataBytes, totalBytesRead, contentLength);
        totalBytesRead += byteRead;
        
        System.out.println(contentLength+"====="+totalBytesRead+"======="+byteRead);
        if(totalBytesRead < 0){
        	return;
        }
    }

    String szFile = new String(dataBytes);

    // ���� ���� �̸��� �����Ѵ�.
    String saveFile = szFile.substring(szFile.indexOf("filename=\"") + 10);
    saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
    saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
    
    int lastIndex = contentType.lastIndexOf("=");
    String boundary = contentType.substring(lastIndex + 1,contentType.length());

    // ����� ������ ������ BODY�� ���� ��ġ ���� ��´�.
    int pos;
    pos = szFile.indexOf("filename=\"");
    pos = szFile.indexOf("\n", pos) + 1;
    pos = szFile.indexOf("\n", pos) + 1;
    pos = szFile.indexOf("\n", pos) + 1;

    // ���� ���� ��ġ ���� ��´�.
    int startPos = ((szFile.substring(0, pos)).getBytes()).length;

    // ���� ���� ũ�⸦ ��´�.
    //out.println(contentLength - startPos - (boundary.length() + 8));
    int dataLength = contentLength - startPos - (boundary.length() + 8);

    // �����ϰ� ���� �̸��� �����.
    String fileName = "";
    for (int i=1; i < 21; i++) {
        int rnd = 1 + (int)(Math.random() * 52);
        rnd = (rnd > 26) ? rnd + 70 : rnd + 64;
        fileName = fileName + (char)(rnd);
    }

    int idx = saveFile.lastIndexOf('.');
    if (idx != -1) {
        String extension = saveFile.substring(idx).toLowerCase();
        fileName = fileName + extension;
    }

    String saveAsFile = SAVE_DIR + fileName;
    FileOutputStream fileOut = new FileOutputStream(saveAsFile);

    fileOut.write(dataBytes, startPos, dataLength);
    fileOut.flush();
    fileOut.close();

	// ���
	out.println("{ fileUrl:'" + SAVE_URL + fileName + "', filePath:'" + saveAsFile +
	"', origName:'" + saveFile + "', fileName:'" + fileName + "', fileSize:'" + dataLength + "'}");
}
%>
