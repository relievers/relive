<script>
	import { goto } from '$app/navigation';
	import ImageScroller from './ImageScroller.svelte';
	import Timeline from './Timeline.svelte';
	import Commentsection from './Commentsection.svelte';
	import {onMount} from "svelte";
	import Api from "./api";

	let events = [];

	let selectedEvent;

	let showingComments;

	export let mediaEndpoint;

	const goBackwards = () => {
		const indexOfPreviousElement = Math.max(events.indexOf(selectedEvent) - 1, 0);
		selectedEvent = events[indexOfPreviousElement];
	};

	const goForwards = () => {
		const indexOfNextElement = Math.min(events.indexOf(selectedEvent) + 1, events.length - 1);
		selectedEvent = events[indexOfNextElement];
	};

	const showComments = () => {
		showingComments = true;
	}

	onMount(() => {
		Api.get(`events/1/${mediaEndpoint}`).then(res => res.json()).then(e => {
			events = e
			selectedEvent = e[0]
		});
	})
</script>

<section class="h-full flex flex-col relative">
	{#if events.length > 0}
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
					src={"/media/" + selectedEvent.imageHash + ".jpg"}
					alt="Main Thumbnail"
			/>
			<!-- Backwards -->
			<!-- <img src="logoWithText.png" alt="Test" /> -->
			<!-- Button Bar -->
			<div class="absolute bottom-10 right-1/3 left-1/3 flex justify-center">
				<button class="flex items-center px-7 py-3 text-white rounded-l-full" style="background-color:#5C3D95">
					<i class="fa fa-star text-2xl mr-2"></i>
				</button>
				<button on:click={showComments} class="flex items-center px-7 py-3 text-white rounded-r-full" style="background-color:#5C3D95">
					<i class="fa fa-comment text-2xl mr-2"></i>
				</button>
			</div>
		</div>
		<ImageScroller {events} bind:selectedEvent />

		{#if showingComments}
			<Commentsection bind:event={selectedEvent} bind:showingComments/>
		{/if}
	{/if}
</section>
