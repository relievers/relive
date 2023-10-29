<script>
	import Comment from "./Comment.svelte";

    let comments = [
        { id: 1, authorId: 1, content: "I still can't explain how this was possible... ^^", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 2, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 3, authorId: 1, content: "Anyone forgot their jacket? Found one...", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 }
    ]

</script>
<div class="space-y-4 bg-background">
    {#each comments as comment (comment.id)}
      <div class="flex items-start space-x-4 p-1 bg-background shadow-md rounded-lg">  
        <Comment {comment}/>
      </div>
    {/each}
  </div>