<script>
    let mockComment = 
        { id: 1, authorId: 1, content: "I still can't explain how this was possible... ^^", dateTime: new Date().toLocaleString("de-DE"), eventId: 1 }
</script>

<div class="flex items-start space-x-4 p-4 rounded-xl">
    <img src="/emptyProfilePicture.png" alt="Profilbild" class="w-12 h-12 rounded-full" />

    <div class="flex-1">
        <div class="flex items-center space-x-2">
            <p class="font-semibold text-gray-400">Username</p>
            <p class="text-gray-600">{mockComment.dateTime}</p>
        </div>
        <p class="text-gray-400">{mockComment.content}</p>
    </div>
</div>