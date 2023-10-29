<script>
	import { goto } from '$app/navigation';
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

	const goBackwards = () => {
		const indexOfPreviousElement = Math.max(events.indexOf(selectedEvent) - 1, 0);
		selectedEvent = events[indexOfPreviousElement];
	};

	const goForwards = () => {
		const indexOfNextElement = Math.min(events.indexOf(selectedEvent) + 1, events.length - 1);
		selectedEvent = events[indexOfNextElement];
	};
</script>

<section class="h-full flex flex-col relative">
	<div class="bg-transparent absolute text-white top-20 left-2 z-30">
		<!-- angle-left -->
		<a href="/events" class="w-8 h-8 p-4 rounded-full">
			<i class="fa fa-close text-2xl mx-auto" />
		</a>
	</div>

	<Timeline />
	<div class="flex-grow relative">
		<!-- svelte-ignore a11y-click-events-have-key-events -->
		<dv class="h-full w-1/4 absolute z-20 opacity-0" on:click={goBackwards} />
		<!-- svelte-ignore a11y-click-events-have-key-events -->
		<dv class="h-full w-1/4 absolute right-0 z-20 opacity-0" on:click={goForwards} />
		<img
			class="max-h-full h-full w-full object-cover rounded-xl -z-10"
			src={selectedEvent.url}
			alt="Main Thumbnail"
		/>
		<!-- Backwards -->
		<!-- <img src="logoWithText.png" alt="Test" /> -->
		<!-- Button Bar -->
		<div class="flex justify-center">
			<button class="flex items-center px-7 py-3 text-white rounded-l-full" style="background-color:#5C3D95">
				<i class="fa fa-star text-2xl mr-2"></i>
			</button>
			<button class="flex items-center px-7 py-3 text-white rounded-r-full" style="background-color:#5C3D95">
				<i class="fa fa-comment text-2xl mr-2"></i>
			</button>
		</div>

	</div>
	<ImageScroller {events} bind:selectedEvent />
</section>
