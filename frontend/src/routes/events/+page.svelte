<script>
    // Mock Data
    let events = [
        { id: 1, state: 'PAST', description: "Day one of coding", startDateTime: '28-10-2023 09:30', duration: 14, displayName: "Basel Hack 2023", ownerId: 1 },
        { id: 2, state: 'ONGOING', description: "Hacking in Pratteln", startDateTime: '28-10-2023 09:30', duration: 36, displayName: "Basel Hack 2023", ownerId: 1 },
        { id: 3, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2024 09:30', duration: 36, displayName: "Basel Hack 2024", ownerId: 1 },
        { id: 4, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2025 09:30', duration: 36, displayName: "Baselhackersasdf 2025", ownerId: 1 },
        { id: 5, state: 'PAST', description: "I love Techno", startDateTime: '25-05-2023 22:30', duration: 2, displayName: "Viertel Klub: Stella Bossi", ownerId: 1 },
        { id: 6, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2025 09:30', duration: 36, displayName: "Baselhack Withverylo", ownerId: 1 },
        { id: 6, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2025 09:30', duration: 36, displayName: "Baselhack Withverylo", ownerId: 1 },
        { id: 6, state: 'PLANNED', description: "Hacking again in Pratteln", startDateTime: '28-10-2025 09:30', duration: 36, displayName: "Baselhack Withverylo", ownerId: 1 },
    ];

    $:prevEvent = events.filter(it => it.state === 'PAST')[0];

    $:ownEvents = events.filter(it => it.ownerId === 1 /* TODO: Change to user.id */)
                        .filter(it => it.state === 'PLANNED' || it.state === 'ONGOING');

</script>

<div class="flex-grow w-full bg-background px-4">
    <div class="flex flex-col justify-center items-center py-14">
        <h1 class="text-white text-4xl">Events</h1>
    </div>
    <div class="flex flex-col">
        <h2 class="text-white text-2xl pt-4">ReLive</h2>
        <a href="/timeline" class="bg-white w-full h-60 rounded-xl my-2 overflow-hidden cursor-pointer relative">
            <img src="/images/event-default-thumbnail.jpg" alt="Image of {prevEvent.displayName}">
            <h3 class="absolute text-white drop-shadow left-1/2 -translate-x-1/2 top-2 font-bold text-xl">{prevEvent.displayName}</h3>
            <!-- TODO: Display thumbnail image of event -->
        </a>
    </div>
    <div class="flex flex-col py-4">
        <a href="/events/past" class="btn bg-white btn-primary rounded-xl text-accent text-center font-bold py-3 my-4">ReLive Past Events</a>
    </div>
    <div class="flex flex-col">
        <h2 class="text-white text-2xl">Manage Events</h2>
        <div class="flex flex-row my-2 overflow-x-scroll overflow-y-hidden">
            {#each ownEvents as event}
                <a href="/events/{event.id}/edit" class="flex flex-col mx-2 items-center cursor-pointer" style="min-width: 5rem; max-width: 5rem; width: 5rem;">
                    <div class="bg-accent p-2 rounded-xl break-words w-full h-full overflow-hidden" style="min-height: 8rem; max-height: 8rem; height: 8rem">
                        <span class="text-white text-xl">
                            {event.displayName}
                        </span>
                    </div>
                    <span class="text-white text-sm pt-1">
                        {event.startDateTime.split(' ')[0]}
                    </span>
                </a>
                
            {/each}
        </div>
    </div>
</div>