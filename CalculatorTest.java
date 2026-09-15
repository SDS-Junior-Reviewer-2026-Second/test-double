import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Mock
    private Adder mockAdder;

    @InjectMocks
    private Calculator calculator;

    @Test
    void addTest() {
        when(mockAdder.add(2, 3))
                .thenReturn(5);

        int result = calculator.add(2, 3);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtractTest() {
        when(mockAdder.add(5, -3))
                .thenReturn(2);

        int result = calculator.subtract(5, 3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiplyTest() {
        when(mockAdder.add(anyInt(), eq(1)))
                .thenAnswer(invocation -> {
                    int firstArgument = invocation.getArgument(0);
                    return firstArgument + 1;
                });

        when(mockAdder.add(anyInt(), eq(3)))
                .thenAnswer(invocation -> {
                    int firstArgument = invocation.getArgument(0);
                    return firstArgument + 3;
                });

        int result = calculator.multiply(3, 3);

        assertThat(result).isEqualTo(9);
    }
}