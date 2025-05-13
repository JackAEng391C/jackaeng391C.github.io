import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame

class My_sprite:
    def __init__(self, image_file_name: str, location: tuple[int, int] = (0, 0)):
        self.image = pygame.image.load(image_file_name)
        self.location = location
        self.width = self.image.get_width()
        self.height = self.image.get_height()

    def get_image(self) -> pygame.Surface:
        return self.image

    def get_width(self) -> int:
        return self.width

    def get_height(self) -> int:
        return self.height

    def __eq__(self, other):
        if not isinstance(other, My_sprite):
            return False
        return (self.get_width() == other.get_width() and
                self.get_height() == other.get_height() and
                self.location == other.location)
