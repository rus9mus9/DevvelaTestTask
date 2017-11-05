<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page ="fragments/bodyHeader.jsp"/>

<section>
    <h3>AAAAAAAA</h3>
    <form method="post" action="productsFromFile" enctype="multipart/form-data">
        Select a file from the computer <input type="file" name="file">
        <button type="submit">Parse from file</button>
    </form>
    <form method="post" action="productsFromUrl">
        <br>
        Or load from URL<input type="url" name="urlFile">
        <br>
        <button type="submit">Parse from URL</button>
    </form>
</section>

<%--<section>
<form method="post" action="products">
    Or load from URL
    <input type="url" name="urlFile">
    <button type="submit">Parse!</button>
</form>
</section>--%>


<%--<section>
    <h3>AAAAAAAA</h3>
    <form method="post" action="products" enctype="multipart/form-data">
        Select a file from the computer <input type="file" name="file">
        <br>
        Or load from URL <input type="url" name="urlFile">
        <br>
        <button type="submit">Parse!</button>

    </form>
</section>--%>
<%--<div id="box1Id">
    <table>
        <tbody>
        <tr>
            <td id="xmlGrid">

    <form id="file_upload_form" method="POST" enctype="multipart/form-data" action="products" target="upload_target">
        <fieldset>
            <legend class="boldText">Open File</legend>
            File Location: &nbsp;<br>
            <input type="file" name="file0" id="file0" size="60">
            <br>
            <input type="hidden" name="mu" value="relayFile">
            <input type="submit" value="Submit">
            <br><br>
            <div class="boldText">
                Help:
            </div>
            <ul>
                <li>Click Browse button to navigate file system.
                </li><li>Click Submit button to load the file into the Editor.
            </li></ul>
        </fieldset>

        <iframe id="upload_target" name="upload_target" src="" style="width:0;height:0;border:0px solid #fff;"></iframe>
    </form>

</td></tr></tbody></table>
</div>--%>
</body>
</html>
