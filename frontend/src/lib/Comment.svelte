<script>
      export let comment;
</script>


<div class="flex items-start space-x-4 p-4 rounded-xl bg-background">
    <img src="/emptyProfilePicture.png" alt="Profilbild" class="w-12 h-12 rounded-full" />

    <div class="flex-1">
        <div class="flex items-center space-x-2">
            <p class="font-semibold text-gray-400">Username</p>
            <p class="text-gray-600">{comment.dateTime}</p>
        </div>
        <p class="text-gray-400">{comment.content}</p>
    </div>
</div>