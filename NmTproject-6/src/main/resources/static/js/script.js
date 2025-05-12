document.addEventListener("DOMContentLoaded", function () {
    const openModal = document.getElementById("openModal");
    const modal = document.getElementById("myModal");
    const closeModal = document.getElementById("closeModal");
    const userIcon = document.getElementById("userIcon");
    const user = document.getElementById("user");

    openModal.onclick = function () {
        modal.style.display = "block";
    };

    closeModal.onclick = function () {
        modal.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };

    userIcon.onclick = function () {
        const rect = userIcon.getBoundingClientRect();

        user.style.left = `${rect.left + window.scrollX}px`;
        user.style.top = `${rect.bottom + window.scrollY}px`;

        user.style.display = "block";
    }
});

const fullscreenicon = document.getElementById('fullscreen');

fullscreenicon.addEventListener('click', function () {
    if (!document.fullscreenElement) {
        document.documentElement.requestFullscreen();
    } else {
        document.exitFullscreen();
    }
});
