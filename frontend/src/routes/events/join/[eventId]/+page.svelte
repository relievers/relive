<script>
	import { goto } from '$app/navigation';
	import { page } from '$app/stores';
	import api from '$lib/api';
	import { getUser, setUser } from '$lib/user-service';
	import { onMount } from 'svelte';

	let user;
	let name = '';

	onMount(() => {
		setUser(null)
		localStorage.setItem("token", null)
		user = getUser();
		if (!user) return;

		joinEvent();
	});

	async function joinEvent() {
		const eventId = $page.params.eventId;
		try {
			const response = await api.post(`events/${eventId}/participations`, {});
			goto('/');
		} catch (e) {
			console.error(e);
		}
	}

	async function createUser() {
		try {
			const response = await api.post('users/', { name: name });
			const json = await response.json();
			const token = json.token;
			localStorage.setItem('token', token);
			setUser(json);
			await joinEvent();
		} catch (e) {
			console.error(e);
		}
	}
</script>

<main
	class="flex-grow bg-background text-center flex flex-col justify-between items-center text-white px-16 py-8 relative"
>
	<button
		on:click={createUser}
		class="bg-accent h-14 w-14 rounded-full absolute bottom-10 mb-4 right-8 flex justify-center items-center"
	>
		<i class="fa fa-arrow-right" />
	</button>
	<!-- <h1 class="text-4xl">Name</h1> -->
	<div />

	<div class="flex flex-col gap-10">
		<h2 class="text-accent text-3xl">What should we call you?</h2>
		<input
			class="bg-background w-full border-b-2 border-accent text-2xl placeholder:text-accent"
			placeholder="Your Name..."
			minlength="2"
			bind:value={name}
		/>
	</div>

	<div />

	<!-- {#if step === 1}
		<Step1 />
	{:else if step === 2}
		<Step2 />
	{/if} -->

	<!-- <div class="w-full h-1 flex justify-between gap-3">
		<div class="w-full bg-accent" class:bg-purple-500={step == 1} />
		<div class="w-full bg-accent" class:bg-purple-500={step == 1} />
	</div> -->
</main>
