


def is_prime(n):
    if n < 2:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def are_relatively_prime(a, b):
    while b != 0:
        a, b = b, a % b
    return a == 1

def primes(n):
    return [i for i in range(2, n + 1) if is_prime(i)]

def prime_decomposition(n):
    factors = []
    divisor = 2
    while n > 1:
        while n % divisor == 0:
            factors.append(divisor)
            n //= divisor
        divisor += 1
    return factors

def has_prime_decomposition_of_size_2_and_factors_are_different(n):
    factors = prime_decomposition(n)
    return len(factors) == 2 and len(set(factors)) == 2

