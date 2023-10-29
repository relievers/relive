<script lang="ts">
	export let events;
	export let selectedEvent;
	export let eventName: string = 'BaselHack 23';

	const selectEvent = (event) => {
		selectedEvent = event;
	};
</script>

<div class="bg-background w-full flex flex-col items-center pt-4 pb-4">
	<div class="flex gap-2 overflow-x-scroll px-4">
		{#each events as event}
			<button on:click={() => selectEvent(event)}
                class="flex-shrink-0">
				<img
					class="bg-black image-card rounded-md object-cover border-white
                    {event === selectedEvent ? 'border' : ''}"
					alt="Thumbnail"
					src={event.url}
				/>
			</button>
		{/each}
	</div>
	<div class="text-center text-sm text-white">
		{eventName}
	</div>
</div>

<style>
	.image-card {
		height: 70px;
		width: 48px;
	}
</style>
