<!doctype html>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>jQuery UI Autocomplete - Multiple values</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="../jtable/jquery-1.9.1.js"></script>
<script src="../jtable/jquery-ui-1.10.3.custom.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
$('#mylist').change(function () {
    var x = document.getElementById("mylist").value;

    if (x == "firstname") {
        var availableTags = [
            "ActionScript",
            "AppleScript",
            "Asp",
            "BASIC",
            "C",
            "C++",
            "Clojure",
            "COBOL",
            "ColdFusion",
            "Erlang",
            "Fortran",
            "Groovy",
            "Haskell",
            "Java",
            "JavaScript",
            "Lisp",
            "Perl",
            "PHP",
            "Python",
            "Ruby",
            "Scala",
            "Scheme"];
        $("#tags").autocomplete({
            source: availableTags
        });


    } else if (x == "lastname") {
        var availableTags = [
            "ActionScript",
            "AppleScript",
            "Asp",
            "BASIC",
            "C",
            "C++",
            "Clojure",
            "COBOL",
            "ColdFusion",
            "Erlang",
            "Fortran",
            "Groovy",
            "Haskell",
            "Java",
            "JavaScript",
            "Lisp",
            "Perl",
            "PHP",
            "Python",
            "Ruby",
            "Scala",
            "Scheme"];
        $("#tags").autocomplete({
            source: availableTags
        });
    }
});



</script>
</head>
<body>
<select id="mylist">
    <option value="">Select one</option>
    <option value="firstname">firstname</option>
    <option value="lastname">lastname</option>
    <option value="fullname">fullname</option>
</select>
<div class="ui-widget">
    <label for="tags">Tags:</label>
    <input id="tags" />
</div>
</body>
</html>