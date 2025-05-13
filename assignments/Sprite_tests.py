import unittest
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
from My_sprite import My_sprite
from Sprite_collection import Sprite_collection

class TestSpriteCollection(unittest.TestCase):
    def setUp(self):
        pygame.init()
        self.img_path = "test_image.png"
        # Create dummy surface and save it for test
        surface = pygame.Surface((50, 100))
        pygame.image.save(surface, self.img_path)

    def tearDown(self):
        os.remove(self.img_path)
        pygame.quit()

    def test_empty_collection(self):
        sc = Sprite_collection()
        s = My_sprite(self.img_path)
        result = sc.search(s)
        self.assertEqual(result, [])

    def test_add_and_search_one_match(self):
        sc = Sprite_collection()
        s1 = My_sprite(self.img_path, (0, 0))
        s2 = My_sprite(self.img_path, (0, 0))
        sc.add(s1)
        result = sc.search(s2)
        self.assertEqual(result, [s1])

    def test_add_and_search_no_match(self):
        sc = Sprite_collection()
        s1 = My_sprite(self.img_path, (0, 0))
        s2 = My_sprite(self.img_path, (10, 10))
        sc.add(s1)
        result = sc.search(s2)
        self.assertEqual(result, [])

    def test_multiple_matches(self):
        sc = Sprite_collection()
        s1 = My_sprite(self.img_path, (5, 5))
        s2 = My_sprite(self.img_path, (5, 5))
        s3 = My_sprite(self.img_path, (5, 5))
        sc.add(s1)
        sc.add(s2)
        sc.add(s3)
        target = My_sprite(self.img_path, (5, 5))
        result = sc.search(target)
        self.assertEqual(len(result), 3)

if __name__ == '__main__':
    unittest.main()
