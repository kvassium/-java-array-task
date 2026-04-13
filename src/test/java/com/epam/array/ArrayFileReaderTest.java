package com.epam.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.array.exception.ArrayValidationException;
import com.epam.array.reader.ArrayFileReader;
import com.epam.array.validation.ArrayDataValidator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for ArrayFileReader.
 */
class ArrayFileReaderTest {

    private static final String TEST_FILE_PATH = "test_data.txt";
    private ArrayFileReader reader;
    private ArrayDataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArrayDataValidator();
        reader = new ArrayFileReader(validator);
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testReadArraysFromFile() throws IOException, ArrayValidationException {
        // given
        createTestFile("1; 2; 3\n4, 5, 6\n");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0));
        assertArrayEquals(new int[]{4, 5, 6}, result.get(1));
    }

    @Test
    void testReadArraysFromFileWithInvalidLines() throws IOException, ArrayValidationException {
        // given
        createTestFile("1; 2; 3\ninvalid line\n5, 6, 7\n");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testReadArraysFromFileWithEmptyLines() throws IOException, ArrayValidationException {
        // given
        createTestFile("1; 2; 3\n\n4, 5, 6\n");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testReadArraysFromFileWithNegativeNumbers() throws IOException, ArrayValidationException {
        // given
        createTestFile("-5; -10; -3\n");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{-5, -10, -3}, result.get(0));
    }

    @Test
    void testReadArraysFromEmptyFile() throws IOException, ArrayValidationException {
        // given
        createTestFile("");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testReadArraysFromNonExistentFile() {
        // when & then
        assertThrows(ArrayValidationException.class, () -> {
            reader.readArraysFromFile("non_existent_file.txt");
        });
    }

    @Test
    void testReadArraysFromFileWithSingleNumber() throws IOException, ArrayValidationException {
        // given
        createTestFile("42\n");

        // when
        List<int[]> result = reader.readArraysFromFile(TEST_FILE_PATH);

        // then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{42}, result.get(0));
    }

    private void createTestFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
            writer.write(content);
        }
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        org.junit.jupiter.api.Assertions.assertArrayEquals(expected, actual);
    }
}
