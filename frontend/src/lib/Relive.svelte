<script>
	import ImageScroller from './ImageScroller.svelte';
	import Timeline from './Timeline.svelte';

	const events = [
		{ id: 1, url: 'https://picsum.photos/id/234/200/300' },
		{ id: 2, url: 'https://picsum.photos/id/233/200/300' },
		{ id: 3, url: 'https://picsum.photos/id/232/200/300' },
		{ id: 4, url: 'https://picsum.photos/id/238/200/300' },
		{ id: 5, url: 'https://picsum.photos/id/239/200/300' },
		{ id: 6, url: 'https://picsum.photos/id/230/200/300' },
		{ id: 7, url: 'https://picsum.photos/id/231/200/300' },
		{ id: 8, url: 'https://picsum.photos/id/236/200/300' },
		{ id: 9, url: 'https://picsum.photos/id/237/200/300' }
	];

	let selectedEvent = events[0];
</script>

<section class="h-full flex flex-col">
	<Timeline />
	<div class="flex-grow">
		<img
			class="max-h-full h-full w-full object-cover rounded-xl"
			src={selectedEvent.url}
			alt="Main Thumbnail"
		/>
		<!-- <img src="logoWithText.png" alt="Test" /> -->
		<!-- Button Bar -->
	</div>
	<ImageScroller {events} bind:selectedEvent />
</section>
