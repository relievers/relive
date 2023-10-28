<script>
	import { each } from "svelte/internal";

    // Mock Data
    let events = [
        { id: 1, state: 'PAST', description: "Day one of coding", startDateTime: '28-10-2023 09:30', duration: 14, displayName: "BaselHack 2023", ownerId: 1 },
        { id: 2, state: 'ONGOING', description: "Hacking in Pratteln", startDateTime: '28-10-2023 09:30', duration: 36, displayName: "BaselHack 2023", ownerId: 1 },
        { id: 3, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2024 09:30', duration: 36, displayName: "BaselHack 2024", ownerId: 1 },
        { id: 4, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2025 09:30', duration: 36, displayName: "BaselHack 2025", ownerId: 1 },
        { id: 5, state: 'PAST', description: "I love Techno", startDateTime: '25-05-2023 22:30', duration: 2, displayName: "Viertel Klub: Stella Bossi", ownerId: 1 }
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

<div class="flex-grow w-full bg-red-300">
    <div class="bg-gray-900 flex flex-col justify-center items-center">
        <h2 class="text-white text-2xl">Your Events</h2>
        {#each events as event}
            {#if event.state === 'PLANNED' && event.ownerId === 1} <!--TODO: OwnerID-->
                <div>
                    <span class="text-white">
                        {event.id}, {event.state}, {event.description}, {event.startDateType}, {event.duration}, {event.displayName}, {event.ownerId}
                    </span>
                </div>
            {/if}
        {/each} 
    </div>
    <div class="bg-gray-900 flex flex-col justify-center items-center">
        <h2 class="text-white text-2xl">ReLive your Memories</h2>
        {#each events as event}
            {#if event.state === 'PAST'} 
                <div style="background-color: #{getColor()}">
                    <span class="text-white">
                        {event.id}, {event.state}, {event.description}, {event.startDateType}, {event.duration}, {event.displayName}, {event.ownerId}
                    </span>
                </div>
                
            {/if}
        {/each}
    </div>
</div>