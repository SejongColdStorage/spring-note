var reader = new commonmark.Parser();
var writer = new commonmark.HtmlRenderer();
var parsed = reader.parse("Hello *world*"); // parsed is a 'Node' tree
// transform parsed if you like...
var result = writer.render(parsed); // result is a String
print(result);