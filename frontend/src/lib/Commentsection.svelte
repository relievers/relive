<script>
	import Comment from './Comment.svelte';

    let comments = [
        { id: 1, authorId: 1, content: "I still can't explain how this was possible... ^^", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 2, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 3, authorId: 1, content: "Anyone forgot their jacket? Found one...", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 4, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 5, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 6, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 7, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 8, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
        { id: 9, authorId: 1, content: "Crazyyyyyyyyyyyyyy", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 },
    ];

	export let event;
	export let showingComments;

	const close = () => {
		showingComments = false;
	};
</script>

<div class="flex flex-col space-y-4 bg-background absolute bottom-0 rounded-t-3xl z-30 overflow-hidden" style="max-height: 50vh;">
	<div class="flex flex-row justify-start mx-4 my-2">
		<button on:click={close}>
			<i class="fa fa-close text-2xl mx-auto text-white" />
		</button>
	</div>
	<div class="flex-grow overflow-y-scroll">
		{#each comments as comment (comment.id)}
			<div class="flex items-start space-x-4 p-1 bg-background shadow-md rounded-lg">
				<Comment {comment} />
			</div>
		{/each}
	</div>
    <div class="flex items-center space-x-4 p-4 bg-white shadow-md rounded-lg">
        <input
          type="text"
          class="flex-1 py-2 px-4 rounded-full bg-gray-100 focus:outline-none focus:ring focus:border-blue-500"
          placeholder="Comment..."
        />
      
        <button type="submit" class="px-4 py-2 text-white rounded-full transition duration-300 ease-in-out" style="background-color: #5C3D95">
            <i class="fa  fa-paper-plane text-1xl mx-auto"></i>
        </button>
      </div>
</div>
