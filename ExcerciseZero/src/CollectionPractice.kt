// Create a class called Comment and pass two parameters, userId of data type Int and message of the data type String
class Comment(val userId: Int, val message: String)
//  create a list and store it in a variable named comments. It should be of the type List<Comment>. The Comment class needs two arguments, userId and message.
val comments List<Comment> = listOf (
    Comment(5241, "Nice"),
    Comment(6624, "Like it"),
    Comment(5224, "Wtf"),
    Comment(9001, "Check me Out"),
    Comment(8818, "Hello everyone")
)

// create a set of blocked users. They will be identified by their userId. For this step, you need to use a set, which is another type of collection
val blockedUserIds: Set<Int> = setOf(5224, 9001)
// create the relationship between the user and the authors of comments. For this, you need to use a map.
val userIdToRelation: Map<Int, String> = mapOf (
    5241 to "friend",
    6624 to "Bff"
)
// display the comments in the forum, but you need to check if the author that comments is blocked or not.
for (comment in comments) {
    // find and display the relationship between the current user and the author of the comment.
    if (comment.userId !in blockedUserIds) {
        val relation = userIdToRelation[comment.userId] ?: "unknown"
    }
    // Print the comment
    println("Comment ${comment.message} from $relation")
}

