<script>
	import Back from "$lib/Back.svelte";

    // Mock Data
    let events = [
        { id: 1, state: 'PAST', description: "Day one of coding", startDateTime: '28-10-2023 09:30', duration: 14, displayName: "Basel Hack 2023", ownerId: 1 },
        { id: 5, state: 'PAST', description: "I love Techno", startDateTime: '25-05-2023 22:30', duration: 2, displayName: "Viertel Klub: Stella Bossi", ownerId: 1 },
        { id: 5, state: 'PAST', description: "I love Techno", startDateTime: '25-05-2023 22:30', duration: 2, displayName: "Viertel Klub: Stella Bossi", ownerId: 1 },
        { id: 5, state: 'PAST', description: "I love Techno", startDateTime: '25-05-2023 22:30', duration: 2, displayName: "Viertel Klub: Stella Bossi", ownerId: 1 },
    ];

    // Color codes for variation
    let colors = ['FFA95A', 'A2EE67', '67A5EE', 'CB67EE', '5C3D95'];

    // iterator for color variation
    let i = 0;

    function getColor() {
        let color = colors[i];
        i += 1;
        i = i % colors.length;
        return color;
    }
</script>

<div class="flex-grow w-full bg-background px-4">
    <Back />
    <div class="flex flex-col justify-center items-center py-14">
        <h1 class="text-white text-4xl">ReLive</h1>
        <p class="text-white">the moments from the past</p>
    </div>
    <div class="flex flex-col w-full">
        {#each events as event}
            <div class="cursor-pointer w-full my-2 py-6 px-4 rounded-xl" style="background-color: #{getColor()}">
                <p class="text-white text-xl">
                    {event.displayName}
                </p>
                <p class="text-white text-sm pt-1">
                    {event.startDateTime.split(' ')[0]}
                </p>
            </div>
        {/each}
    </div>
</div>