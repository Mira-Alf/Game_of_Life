import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String htmlLine = scanner.nextLine();
        parseHtmlTag(htmlLine);
    }

    public static void parseHtmlTag(String htmlLine) {
        HtmlTag.createTagAndPopulateChildTags(htmlLine, null);
        HtmlTag.processChildTags(null);
    }
}

class HtmlTag {

    public static HtmlTag rootTag;
    private String tagName;
    private String innerHTML;
    private List<HtmlTag> childTags = new ArrayList<>();

    public HtmlTag(String tagName, String innerHTML) {
        this.tagName = tagName;
        this.innerHTML = innerHTML;
    }

    public String toString() {
        return tagName+":"+innerHTML+":"+childTags;
    }

    public static void createTagAndPopulateChildTags(String htmlLine, HtmlTag parentTag) {
        Pattern openingTag = Pattern.compile("<[a-zA-Z0-9]+>");
        Matcher matcher = openingTag.matcher(htmlLine);
        if (matcher.find()) {
            String oTag = matcher.group();
            String closingtag = "</" + oTag.substring(1);
            String tagName = oTag.substring(1, oTag.indexOf(">"));
            //System.out.println("tagName"+tagName);
            Pattern contentOfTag = Pattern.compile(oTag + "[^"+oTag+">]*.*" + closingtag);
            Matcher contentMatcher = contentOfTag.matcher(htmlLine);

            if (contentMatcher.find()) {
                String tagContent = contentMatcher.group();
                //System.out.println("tagContent"+tagContent);
                tagContent = tagContent.substring(tagContent.indexOf(">") + 1);
                tagContent = tagContent.substring(0, tagContent.indexOf(closingtag));
                //System.out.println(tagName + ":" + tagContent);
                HtmlTag tag = new HtmlTag(tagName, tagContent);
                if (parentTag == null)
                    rootTag = tag;
                else
                    parentTag.childTags.add(tag);
                createTagAndPopulateChildTags(tagContent, tag);
                htmlLine = htmlLine.replace("<" + tagName + ">", "");
                htmlLine = htmlLine.replace("</" + tagName + ">", "");
                htmlLine = htmlLine.replace(tagContent, "");
                if(htmlLine.length()>0)
                    createTagAndPopulateChildTags(htmlLine, parentTag);
            }
        }

    }

    public static void processChildTags(HtmlTag startTag) {

        if(startTag == null)
            startTag = rootTag;
        //System.out.println("->tagName"+startTag.tagName);
        //System.out.println("->tagName"+startTag.childTags);
        if(startTag.childTags.size()==0) {
            System.out.println(startTag.innerHTML);
            return;
        }
        startTag.childTags.forEach(tag->{
            processChildTags(tag);
        });
        System.out.println(startTag.innerHTML);
    }
}

